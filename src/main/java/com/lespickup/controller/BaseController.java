package com.lespickup.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class BaseController {


    private static final Logger logger = Logger.getLogger(BaseController.class.getName());


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelMap model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
            mv.setViewName("index");
            return mv;
    }
    

    @GetMapping("/persons")
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