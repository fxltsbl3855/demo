package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.model.rest.*;
import com.yto.mdm.manager.impl.UserManagerImpl;
import com.yto.mdm.mybatis.entity.User;
import com.yto.mdm.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserTestController {

    @Autowired
    public UserManagerImpl userManager;

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("user");
    }

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public DataResult add(UserVo user) {
        userManager.add(user);
        return DataResult.ok();
    }

    /**
     * 根据条件查询用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public DataResult<BasePageResponse> queryPage(UserVo user) {
        //TODO status，message 在jar包中应该定义成常量
        return new DataResult<BasePageResponse>(0, "ok", userManager.queryPage(user));
    }

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public DataResult delete(User user) {
        userManager.delete(user);
        return DataResult.ok();
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public DataResult update(UserVo user) {
        userManager.update(user);
        return DataResult.ok();
    }

}
