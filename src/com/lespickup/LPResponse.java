package com.lespickup;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LPResponse {

    private String message;

    public LPResponse() {
    }

    public LPResponse(String message){
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
