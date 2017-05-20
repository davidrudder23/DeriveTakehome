package org.dave.derive.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.objectify.ObjectifyService;

public class Bootstrap {

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    protected void init() {
        log.info("Starting app");

        registerEntities();
    }

    private void registerEntities() {

        log.info("Done registering entities.");
    }

}
