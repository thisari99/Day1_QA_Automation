package com.rootcodelabs.java.day8.sauce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("C:\\automation training\\QA_Automation\\src\\test\\resources\\sauce.properties")));
        } catch (IOException e ){
            throw new RuntimeException(e);
        }
    }

    public static String getBaseURL() {
        return properties.getProperty("base.url");
    }
}
