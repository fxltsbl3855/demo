package com.yto.mdm.mybatis.datasource1.mapper;

import com.github.pagehelper.Page;
import com.yto.mdm.mybatis.datasource1.entity.User;
import tk.mybatis.mapper.common.BaseMapper;

public interface UsersMapper extends BaseMapper<User> {

    Page<User> query(User user);

}