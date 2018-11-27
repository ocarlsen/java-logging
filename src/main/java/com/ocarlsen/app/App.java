package com.ocarlsen.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Demo app showcasing Java logging framework.
 */
public class App {

    private final Logger logger;

    public App(String configFile) throws IOException {

        // Configuration file is not automatically loaded.
        // Use this to search classpath.
        logger = configureLogging(configFile);
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

    private Logger configureLogging(String configFile) throws IOException {

        URL configurationUrl = getClass().getClassLoader().getResource(configFile);
        if (configurationUrl == null) {
            throw new IllegalStateException("Unable to find configuration file: " + configFile);
        }

        InputStream inputStream = configurationUrl.openStream();
        LogManager.getLogManager().readConfiguration(inputStream);

        return Logger.getLogger(getClass().getName());
    }

    public static void main(String[] args) throws IOException {
        new App("logging.properties").demoLogger();
    }
}
