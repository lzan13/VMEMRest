package com.vmloft.develop.java.emrest;

import com.google.gson.JsonObject;
import io.swagger.client.ApiException;
import io.swagger.client.model.*;
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
        result = VMTokenAPI.getAccessToken();

        try {
            // 注册账户
            RegisterUsers users = new RegisterUsers();
            User user = new User().username("lz0").password("1");
            users.add(user);
            result = new VMUserAPI().createIMUserSingle(users);

            // 批量注册
            User user1 = new User().username("lz2").password("1");
            User user2 = new User().username("lz3").password("1");
            users.add(user1);
            users.add(user2);
            //            result = new VMUserAPI().createIMUserBatch(users);

            // 获取账户信息
            //            result = new VMUserAPI().getIMUserByUsername("lz1");

            // 获取历史记录
            //            result = new VMChat().getHistoryFile("201705110800");

            // 发送消息
            //            Msg msg = new Msg();
            //            MsgContent msgContent = new MsgContent().type(MsgContent.TypeEnum.CMD);
            //            UserName username = new UserName();
            //            username.add("lz1");
            //            username.add("lz2");
            //            msg.msg(msgContent).from("lz0").target(username).targetType("users");
            //            // 普通扩展
            //            JsonObject extObject = new JsonObject();
            //            extObject.addProperty("key1", "value1");
            //            extObject.addProperty("key2", "value2");
            //            extObject.addProperty("key3", 1);
            //            extObject.addProperty("key4", true);
            //            // 这里是设置强制推送，这个属于普通扩展
            //            extObject.addProperty("em_force_notification", true);
            //
            //            // 自定义推送部分，这个是一个独立的 json，要放在上个 json 中
            //            JsonObject pushObject = new JsonObject();
            //            pushObject.addProperty("em_push_name", "推送标题");
            //            pushObject.addProperty("em_push_content", "推送内容部分");
            //            extObject.addProperty("em_apns_ext", String.valueOf(pushObject));
            //
            //            // 设置扩展
            //            msg.ext(extObject);
            //            result = new VMChat().sendMessage(msg);
        } catch (ApiException e) {
            result = "APIException code:" + e.getCode() + ", response: " + e.getResponseBody();
        }


        logger.info(result.toString());
    }
}

