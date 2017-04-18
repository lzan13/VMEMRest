package com.vmloft.develop.java.emrest;

import io.swagger.client.ApiException;
import io.swagger.client.api.UsersApi;
import io.swagger.client.model.RegisterUsers;

/**
 * Created by lzan13 on 2017/4/18.
 * 调用环信 User 相关 API 操作
 */
public class VMUserAPI {

    private UsersApi usersAPI = new UsersApi();

    /**
     * 创建单个账户
     */
    public Object createIMUserSingle(Object object) throws ApiException {
        return usersAPI.orgNameAppNameUsersPost(VMConfig.EM_ORG_NAME, VMConfig.EM_APP_NAME, (RegisterUsers) object, VMTokenAPI.getAccessToken());
    }

    /**
     * 批量注册账户
     *
     * @param object 需要注册的账户集合
     */
    public Object createIMUserBatch(Object object) throws ApiException {
        return usersAPI.orgNameAppNameUsersPost(VMConfig.EM_ORG_NAME, VMConfig.EM_APP_NAME, (RegisterUsers) object, VMTokenAPI.getAccessToken());
    }

    /**
     * 根据 username 获取 IM User 信息
     *
     * @param username 需要获取的 username
     */
    public Object getIMUserByUsername(String username) throws ApiException {
        return usersAPI.orgNameAppNameUsersUsernameGet(VMConfig.EM_ORG_NAME, VMConfig.EM_APP_NAME, VMTokenAPI.getAccessToken(), username);
    }

}
