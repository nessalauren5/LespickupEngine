package com.lespickup.controller;


import com.lespickup.pojo.LPResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class BaseController {

    private static final Logger logger = Logger.getLogger(BaseController.class.getName());

    @Value("#{props['faappId']}")
    public String FACEBOOK_APP_ID;

    @Value("#{props['faappSec']}")
    public String CLIENT_SECRET;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/")
    public ResponseEntity<String> helloagain() {
        logger.log(Level.INFO,"inside helloagain");
        return ResponseEntity.ok().build();
    }


    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LPResponse> helloAgain(@RequestParam String name) {
        if (name != null && !name.isEmpty()) {
            logger.log(Level.INFO, "Hello " + name);
            LPResponse lpr = new LPResponse("Hello " + name);
            return ResponseEntity.ok().body(lpr);
        }
        else {
            LPResponse lpr = new LPResponse("Hello, no name given!");
            return ResponseEntity.ok().body(lpr);
        }
    }
}