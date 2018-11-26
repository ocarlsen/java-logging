package com.ocarlsen.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {

    public static final String JAVA_UTIL_LOGGING_CONFIG_FILE_PROPERTY = "java.util.logging.config.file";
    private Logger logger;

    public App() {

    }

    public void run() {
        configureLogging();
        String name = getClass().getName();
        logger = Logger.getLogger(name);

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    private void configureLogging() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/logging.properties");
            LogManager.getLogManager().readConfiguration(inputStream);
        } catch (final IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
