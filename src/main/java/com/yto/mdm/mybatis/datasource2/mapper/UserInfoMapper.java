package com.yto.mdm.mybatis.datasource2.mapper;

import com.github.pagehelper.Page;
import com.yto.mdm.mybatis.datasource2.entity.UserInfo;
import tk.mybatis.mapper.common.BaseMapper;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    Page<UserInfo> query(UserInfo user);

}