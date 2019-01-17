package com.yto.mdm.manager;

import cn.com.yto56.basic.framework.model.rest.BasePageResponse;
import com.yto.mdm.mybatis.datasource1.entity.User;
import com.yto.mdm.mybatis.datasource2.entity.UserInfo;
import com.yto.mdm.vo.UserInfoVo;
import com.yto.mdm.vo.UserVo;

public interface UserTestManager {

    void setRedis(String key,String value);

    String getRedis(String key);

    int add(UserVo user);

    BasePageResponse<User> queryPage(UserVo user);

    BasePageResponse<UserInfo> queryPageFromDS2(UserInfoVo userInfo);

    int delete(User user);

    int update(UserVo user);
}
