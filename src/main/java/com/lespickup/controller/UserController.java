package com.lespickup.controller;

import com.lespickup.pojo.LPResponse;
import com.lespickup.util.ParameterStringBuilder;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    @PostMapping("/signin/{token}")
    public ResponseEntity<LPResponse> signin(@PathVariable("token") String aToken) {
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
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();
            JSONObject response = getFacebookUser(con);
            BigInteger id = response.getBigInteger("id");
            lpr = new LPResponse("id=" + id.toString());

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

    public JSONObject getFacebookUser(HttpsURLConnection connection) throws IOException{
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
