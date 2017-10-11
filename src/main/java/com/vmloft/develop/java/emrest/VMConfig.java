package com.vmloft.develop.java.emrest;

import io.swagger.client.ApiClient;
import io.swagger.client.model.Token;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lzan13 on 2017/4/17.
 * 读取配置文件操作类，将配置信息读取到内存
 */
public class VMConfig {
    // 初始化 Logger
    private static Logger logger = LoggerFactory.getLogger(VMConfig.class);

    public static String EM_BASE_URL;
    public static String EM_ORG_NAME;
    public static String EM_APP_NAME;
    public static String EM_GRANT_TYPE;
    public static String EM_CLIENT_ID;
    public static String EM_CLIENT_SECRET;
    public static Token tokenBody;

    static {
        InputStream inputStream = VMTokenAPI.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        EM_BASE_URL = prop.getProperty("EM_BASE_URL");
        EM_ORG_NAME = prop.getProperty("EM_ORG_NAME");
        EM_APP_NAME = prop.getProperty("EM_APP_NAME");
        EM_GRANT_TYPE = prop.getProperty("EM_GRANT_TYPE");
        EM_CLIENT_ID = prop.getProperty("EM_CLIENT_ID");
        EM_CLIENT_SECRET = prop.getProperty("EM_CLIENT_SECRET");
        tokenBody = new Token().grantType(EM_GRANT_TYPE).clientId(EM_CLIENT_ID).clientSecret(EM_CLIENT_SECRET);
        logger.info("init project config success!");
    }
}
