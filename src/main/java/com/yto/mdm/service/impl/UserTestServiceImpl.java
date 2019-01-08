package com.yto.mdm.service.impl;

import cn.com.yto56.basic.framework.model.rest.BasePageResponse;
import cn.com.yto56.basic.framework.model.rest.MutiResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yto.mdm.exception.user.UserParamException;
import com.yto.mdm.mybatis.datasource1.entity.User;
import com.yto.mdm.mybatis.datasource1.mapper.UsersMapper;
import com.yto.mdm.mybatis.datasource2.entity.UserInfo;
import com.yto.mdm.mybatis.datasource2.mapper.UserInfoMapper;
import com.yto.mdm.service.UserTestService;
import com.yto.mdm.vo.UserInfoVo;
import com.yto.mdm.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 校验用户名是否合业务规则，增加user对象，
     * 规则：不能为空，并且用户名长度不能小于6
     * 如果不和业务规则，抛出自定义的业务异常，一般针对每种业务情况需要定义不同的业务异常
     * @param user
     * @return 新加用户的ID
     */
    @Override
    public int add(UserVo user) {
        String userName = user.getUser().getName();
        if(userName == null || "".equals(userName.trim()) || userName.length() < 6){
            throw new UserParamException("param user name is invalid");
        }
        return usersMapper.insert(user.getUser());
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
        Page<User> page = usersMapper.query(user.getUser());
        BasePageResponse<User> pageResponse = new MutiResponse<User>();
        pageResponse.setTotal(page.getTotal());
        pageResponse.setItems(page);
        return pageResponse;
    }

    @Override
    public BasePageResponse<UserInfo> queryPageFromDS2(UserInfoVo user) {
        PageHelper.startPage(user.getPageNo(), user.getLimit());
        Page<UserInfo> page = userInfoMapper.query(user.getUserInfo());
        BasePageResponse<UserInfo> pageResponse = new MutiResponse<UserInfo>();
        pageResponse.setTotal(page.getTotal());
        pageResponse.setItems(page);
        return pageResponse;
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @Override
    public int delete(User user) {
        return usersMapper.delete(user);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public int update(UserVo user) {
        return usersMapper.updateByPrimaryKey(user.getUser());
    }

}
