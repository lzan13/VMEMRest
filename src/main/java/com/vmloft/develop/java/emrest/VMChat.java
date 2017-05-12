package com.vmloft.develop.java.emrest;

import io.swagger.client.ApiException;
import io.swagger.client.api.ChatHistoryApi;
import io.swagger.client.api.MessagesApi;
import io.swagger.client.model.Msg;

/**
 * Created by lzan13 on 2017/4/20.
 */
public class VMChat {
    private ChatHistoryApi chatHistoryApi = new ChatHistoryApi();

    private MessagesApi messagesApi = new MessagesApi();

    /**
     * 获取聊天记录
     *
     * @return
     */
    public Object getHistoryFile(String time) throws ApiException {
        return chatHistoryApi.orgNameAppNameChatmessagesTimeGet(VMConfig.EM_ORG_NAME, VMConfig.EM_APP_NAME, VMTokenAPI.getAccessToken(), time);
    }

    public Object sendMessage(Object object) throws ApiException {
        return messagesApi.orgNameAppNameMessagesPost(VMConfig.EM_ORG_NAME, VMConfig.EM_APP_NAME, VMTokenAPI.getAccessToken(), (Msg) object);
    }

}
