package com.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager{
    private static ConfigManager configManager;
    private static Properties properties;
    private String fileName="db.properties";
    public ConfigManager() {
        properties=new Properties();
        InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static ConfigManager getInstance(){
        if (configManager == null){
            configManager=new ConfigManager();
        }
        return configManager;
    }
    public static String getString(String key){
        return properties.getProperty(key);
    }
}
