package com.ocarlsen.app;

import com.ocarlsen.app.util.LogUtil;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Demo app showcasing Java logging framework.
 */
public class App {

    private final Logger logger;

    public App() {
        logger = Logger.getLogger(LogUtil.class.getName());
    }

    private void demoLogger() {

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

        // Log an exception.
        RuntimeException ex = new RuntimeException("Oops!");
        logger.log(Level.WARNING, ex.getMessage(), ex);
    }

    public static void main(String[] args) throws IOException {
        // Could also set 'java.util.logging.config.file' system property on command line.
        LogUtil.configureFrom("logging.properties");
        new App().demoLogger();
    }
}
