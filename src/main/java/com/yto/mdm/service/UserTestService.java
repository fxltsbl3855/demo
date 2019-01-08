package com.yto.mdm.service;

import cn.com.yto56.basic.framework.model.rest.BasePageResponse;
import com.yto.mdm.mybatis.datasource1.entity.User;
import com.yto.mdm.mybatis.datasource2.entity.UserInfo;
import com.yto.mdm.vo.UserInfoVo;
import com.yto.mdm.vo.UserVo;

public interface UserTestService {

    int add(UserVo user);

    BasePageResponse<User> queryPage(UserVo user);

    BasePageResponse<UserInfo> queryPageFromDS2(UserInfoVo userInfo);

    int delete(User user);

    int update(UserVo user);
}
