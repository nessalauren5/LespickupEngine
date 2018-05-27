package com.lespickup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class BaseController {

    @GetMapping
    public ResponseEntity <LPResponse> hello() {
        LPResponse lpr = new LPResponse("Hello Vanessa!");
        return ResponseEntity.ok(lpr);
    }

}