package com.lespickup;

import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("lp")
public class BaseController {
    Logger logger = Logger.getLogger(WSConfig.class);
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hello")
    public LPResponse hello(){
        logger.debug("Making call to /hello");
        return new LPResponse("Hello Vanessa!");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/")
    public String hello2(){
       return "<html><body><div><h1>Hello WWorld!</h1></div></body></html>";
    }
}
