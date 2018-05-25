package com.lespickup;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;

@ApplicationPath("api")
public class WSConfig extends Application {

    Logger logger = Logger.getLogger(WSConfig.class);

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addRestResourcesClasses(resources);
        return resources;
    }

    private void addRestResourcesClasses(Set<Class<?>> resources) {
        logger.debug("Adding Resource classes.");
        resources.add(BaseController.class);
    }



}
