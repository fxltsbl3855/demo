package com.yto.mdm.service.impl;

import cn.com.yto56.basic.framework.model.rest.BasePageResponse;
import cn.com.yto56.basic.framework.model.rest.MutiResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yto.mdm.exception.user.UserException;
import com.yto.mdm.mybatis.entity.User;
import com.yto.mdm.mybatis.mapper.UserMapper;
import com.yto.mdm.service.UserService;
import com.yto.mdm.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.ConnectException;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(UserVo user) {
        try {
            return userMapper.insert(user.getUser());
        }catch (Exception e){
            //TODO 如果用户插入失败，写入操作日志，根据业务情况进行其他分支处理
            throw new UserException("user add error");
        }
    }

    /**
     * 分页查询示例（使用github pageHelper）
     * 1 设置分页信息（页大小，第几页）
     * 2 查询调用
     * @param user
     * @return 集合
     */
    @Override
    public BasePageResponse<User> queryPage(UserVo user) {
        PageHelper.startPage(user.getPageNo(), user.getLimit());
        Page<User> page = userMapper.query(user.getUser());
        BasePageResponse<User> pageResponse = new MutiResponse<User>();
        pageResponse.setTotal(page.getTotal());
        pageResponse.setItems(page);
        return pageResponse;
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }

    @Override
    public int update(UserVo user) {
        return userMapper.updateByPrimaryKey(user.getUser());
    }

}
