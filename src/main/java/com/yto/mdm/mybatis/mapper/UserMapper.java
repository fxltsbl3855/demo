package com.yto.mdm.mybatis.mapper;

import com.github.pagehelper.Page;
import com.yto.mdm.mybatis.entity.User;
import tk.mybatis.mapper.common.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

    Page<User> query(User user);

}