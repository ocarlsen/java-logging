package com.ocarlsen.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.LogManager;

public class LogUtil {

    public static void configureFrom(String configFile) throws IOException {

        URL configurationUrl = LogUtil.class.getClassLoader().getResource(configFile);
        if (configurationUrl == null) {
            throw new IllegalStateException("Unable to find configuration file: " + configFile);
        }

        InputStream inputStream = configurationUrl.openStream();
        LogManager.getLogManager().readConfiguration(inputStream);
    }
}
