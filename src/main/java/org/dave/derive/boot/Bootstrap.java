package org.dave.derive.boot;

import com.googlecode.objectify.ObjectifyService;

import org.dave.derive.persistence.entity.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bootstrap {

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    protected void init() {
        log.info("Starting app");

        registerEntities();
    }

    private void registerEntities() {
        log.info("Registering entities...");
        ObjectifyService.register(Example.class);


        log.info("Done registering entities.");
    }

}
