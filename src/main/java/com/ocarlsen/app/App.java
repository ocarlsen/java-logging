package com.ocarlsen.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {

    public static final String JAVA_UTIL_LOGGING_CONFIG_FILE_PROPERTY = "java.util.logging.config.file";
    private Logger logger;

    public App() {
        configureLogging();
    }

    public void demoLogger() {
        String name = getClass().getName();
        logger = Logger.getLogger(name);

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

    private void configureLogging() {
        try {
            // Not automatically loaded.
            // Need to get it from the JAR file built by Maven.
            InputStream inputStream = getClass().getResourceAsStream("/logging.properties");
            LogManager.getLogManager().readConfiguration(inputStream);
        } catch (final IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new App().demoLogger();
    }
}
