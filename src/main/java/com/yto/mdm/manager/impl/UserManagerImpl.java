package com.yto.mdm.manager;

import cn.com.yto56.basic.framework.model.rest.BasePageResponse;
import com.yto.mdm.mybatis.entity.User;
import com.yto.mdm.service.UserService;
import com.yto.mdm.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserService userService;

    @Override
    public int add(UserVo userVo) {
        return userService.add(userVo);
    }

    @Override
    public BasePageResponse<User> queryPage(UserVo userVo) {
        return userService.queryPage(userVo);
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
