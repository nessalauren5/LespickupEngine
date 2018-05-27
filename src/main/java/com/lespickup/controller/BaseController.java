package com.lespickup.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.*;

@RestController
@RequestMapping("/api")
public class BaseController {

    @GetMapping("persons")
    public ResponseEntity <LPResponse> hello() {
        LPResponse lpr = new LPResponse("Hello Vanessa!");
        return ResponseEntity.ok(lpr);
    }

}