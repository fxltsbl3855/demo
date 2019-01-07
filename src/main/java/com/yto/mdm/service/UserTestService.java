package com.yto.mdm.service;

import cn.com.yto56.basic.framework.model.rest.BasePageResponse;
import com.yto.mdm.mybatis.entity.User;
import com.yto.mdm.vo.UserVo;

public interface UserTestService {

    int add(UserVo user);

    BasePageResponse<User> queryPage(UserVo user);

    int delete(User user);

    int update(UserVo user);
}