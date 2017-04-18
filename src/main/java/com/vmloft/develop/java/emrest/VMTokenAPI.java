package com.vmloft.develop.java.emrest;

import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.api.AuthenticationApi;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lzan13 on 2017/4/17.
 * Token 工具类
 */
public class VMTokenAPI {

    // 初始化 Logger
    private static Logger logger = LoggerFactory.getLogger(VMMain.class);

    private static AuthenticationApi authAPI = new AuthenticationApi();
    private static String accessToken;
    private static Double expiredAt = -1d;

    /**
     * 初始化 sdk，其实这里已经获取到 token 了
     * 真实开发中这里需要保存和验证 token，
     * 第一次直接获取，获取之后保存 token，下次先获取自己保存的 token，判断是否失效，没有失效直接返回，否则重新获取
     */
    public static void initToken() {
        try {
            String resp = authAPI.orgNameAppNameTokenPost(VMConfig.EM_ORG_NAME, VMConfig.EM_APP_NAME, VMConfig.tokenBody);
            logger.info("请求结果：" + resp);
            Gson gson = new Gson();
            Map map = gson.fromJson(resp, Map.class);
            accessToken = " Bearer " + map.get("access_token");
            expiredAt = System.currentTimeMillis() + (Double) map.get("expires_in");
        } catch (ApiException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * get Token from memory
     */
    public static String getAccessToken() {
        if (accessToken == null || isExpired()) {
            initToken();
        }
        return accessToken;
    }

    /**
     * 判断 token 是否失效
     */
    private static Boolean isExpired() {
        return System.currentTimeMillis() > expiredAt;
    }
}
