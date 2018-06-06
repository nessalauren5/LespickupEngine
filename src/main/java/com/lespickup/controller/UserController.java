package com.lespickup.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    private static final Logger logger = Logger.getLogger(UserController.class.getName());


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/")
    public ResponseEntity<String> helloagain() {
        logger.log(Level.INFO,"inside user");
        return ResponseEntity.ok().build();
    }
}
