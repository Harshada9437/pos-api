package com.orderapi.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    public static String api_key;
    public static String short_code;
    public static String data_dir;
    public static String app_path;
    public static String username;
    public static String password;
    public static String staging_url;
    public static String db_host;
    public static String db_username;
    public static String db_password;
    public static String db_name;
    public static String db_port;
    public static String issuer;
    public static String subject;
    public static String sessionExpiry;

    static {
        try {

            app_path = new File(System.getProperty("catalina.home") + "/webapps").getAbsolutePath();

            Properties prop = new Properties();
            File propertyFile = new File(app_path + "/pos.properties");
            prop.load(new FileInputStream(propertyFile));

            data_dir = app_path + "/" + prop.getProperty("data_dir") + "/";
            api_key = prop.getProperty("api_key");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            short_code = prop.getProperty("short_code");
            staging_url=prop.getProperty("staging_url");
            db_host=prop.getProperty("db_host");
            db_username=prop.getProperty("db_username");
            db_password=prop.getProperty("db_password");
            db_name=prop.getProperty("db_name");
            db_port=prop.getProperty("db_port");
            sessionExpiry=prop.getProperty("sessionExpiry");
            subject=prop.getProperty("subject");
            issuer=prop.getProperty("issuer");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Can not read property file...");
        }
    }
}
