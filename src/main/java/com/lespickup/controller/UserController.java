package com.lespickup.controller;

import com.lespickup.pojo.LPResponse;
import com.lespickup.util.ParameterStringBuilder;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    @PostMapping("/signin")
    public ResponseEntity<LPResponse> signin(@RequestParam("token") String aToken) {
        LPResponse lpr;

        try {
            URL url = new URL("https://graph.facebook.com/me");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("access_token", aToken);
            parameters.put("fields","id,name,email");
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();
            JSONObject response = getFacebookResult(con);
            logger.log(Level.INFO,response.toString(5));
            url = new URL("https://graph.facebook.com/oauth/access_token");
            con.disconnect();
            con = (HttpsURLConnection) url.openConnection();
            parameters.remove("access_token");
            parameters.remove("fields");
            parameters.put("grant_type","fb_exchange_token");
            parameters.put("client_id",FACEBOOK_APP_ID);
            parameters.put("client_secret",CLIENT_SECRET);
            parameters.put("fb_exchange_token",aToken);
            con.setDoOutput(true);
            DataOutputStream out2 = new DataOutputStream(con.getOutputStream());
            out2.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out2.flush();
            out2.close();
            JSONObject llResponse = getFacebookResult(con);
            lpr = new LPResponse(llResponse.toString(5));

        }
        catch (MalformedURLException e) {
            lpr = new LPResponse("invalid_token_url");
        } catch (ProtocolException e) {
            lpr = new LPResponse("protocol_exception");
        } catch (IOException e) {
            lpr = new LPResponse("io_exception");
        }
        return ResponseEntity.ok().body(lpr);
    }

    public JSONObject getFacebookResult(HttpsURLConnection connection) throws IOException{
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(
                connection.getInputStream()))) {
            return new JSONObject(readAll(rd));
        }
    }

    private static String readAll(Reader rd) throws IOException {

        StringBuilder sb = new StringBuilder();

        int cp;

        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }
}
