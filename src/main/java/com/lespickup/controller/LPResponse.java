package com.lespickup.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LPResponse {

    private String message;


    public LPResponse(){
        this.message="success";
    }
    public LPResponse(String msg){
        this.message = msg;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

