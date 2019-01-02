package com.yto.mdm.vo;

import cn.com.yto56.basic.framework.model.rest.BasePageRequest;
import com.yto.mdm.mybatis.entity.User;

public class UserVo extends BasePageRequest {

    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
