package com.lespickup.controller;



public class LPResponse {

    private String message;


    public LPResponse(){

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

