package com.vmloft.develop.java.emrest;

import io.swagger.client.ApiException;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lzan13 on 2017/4/17.
 * 项目入口类
 */
public class VMMain {
    private static Logger logger = LoggerFactory.getLogger(VMMain.class);

    public static void main(String[] args) {

        Object result = null;

        // 获取管理员 token
        // logger.info("get token" + accessToken);
        //  result = VMTokenAPI.getAccessToken();

        try {
            // 注册账户
            RegisterUsers users = new RegisterUsers();
            // User user = new User().username("lz0").password("1");
            // users.add(user);
            // result = new VMUserAPI().createIMUserSingle(users);
            // 批量注册
            // User user1 = new User().username("lz2").password("1");
            // User user2 = new User().username("lz3").password("1");
            // users.add(user1);
            // users.add(user2);
            // result = new VMUserAPI().createIMUserBatch(users);
            // 获取账户信息
            result = new VMUserAPI().getIMUserByUsername("lz1");
        } catch (ApiException e) {
            result = "APIException code:" + e.getCode() + ", response: " + e.getResponseBody();
        }


        logger.info(result.toString());
    }
}

