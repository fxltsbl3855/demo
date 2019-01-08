package com.yto.mdm.vo;

import cn.com.yto56.basic.framework.model.rest.BasePageRequest;
import com.yto.mdm.mybatis.datasource2.entity.UserInfo;

public class UserInfoVo extends BasePageRequest {

    UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
