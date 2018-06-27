package com.lespickup.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    private static final Logger logger = Logger.getLogger(UserController.class.getName());


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody LPResponse userhello() {
        logger.log(Level.INFO,"inside user hello");
        LPResponse resp = new LPResponse("hello!");
        return resp;
    }

    @RequestMapping(value = "/goodbye", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity userdefault() {
        logger.log(Level.INFO,"inside user");
        return new ResponseEntity(HttpStatus.OK);
    }
}
