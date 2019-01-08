package com.yto.mdm.manager.impl;

import cn.com.yto56.basic.framework.model.rest.BasePageResponse;
import com.yto.mdm.manager.UserTestManager;
import com.yto.mdm.mybatis.datasource1.entity.User;
import com.yto.mdm.mybatis.datasource2.entity.UserInfo;
import com.yto.mdm.service.UserTestService;
import com.yto.mdm.vo.UserInfoVo;
import com.yto.mdm.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UserTestManagerImpl implements UserTestManager {
    private static final Logger logger = LoggerFactory.getLogger(UserTestManagerImpl.class);

    @Autowired
    private UserTestService userService;

    @Override
    public int add(UserVo userVo) {
        return userService.add(userVo);
    }

    @Override
    public BasePageResponse<User> queryPage(UserVo userVo) {
        return userService.queryPage(userVo);
    }

    @Override
    public BasePageResponse<UserInfo> queryPageFromDS2(UserInfoVo userInfoVo) {
        return userService.queryPageFromDS2(userInfoVo);
    }

    @Override
    public int delete(User user) {
        return userService.delete(user);
    }

    @Override
    public int update(UserVo user) {
        return userService.update(user);
    }

}
