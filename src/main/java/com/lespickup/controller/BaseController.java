package com.lespickup.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.*;

@RestController
@RequestMapping("/api")

public class BaseController {


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/")
    public ResponseEntity<String> helloagain() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LPResponse> hello() {
        LPResponse lpr = new LPResponse("Hello Vanessa!");
        return ResponseEntity.ok().body(lpr);
    }

}