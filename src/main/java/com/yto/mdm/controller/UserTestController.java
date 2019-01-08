package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.model.rest.*;
import com.yto.mdm.manager.impl.UserTestManagerImpl;
import com.yto.mdm.mybatis.entity.User;
import com.yto.mdm.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserTestController {
    private static final Logger logger = LoggerFactory.getLogger(UserTestController.class);

    @Autowired
    public UserTestManagerImpl userManager;

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
        BasePageResponse<User>  res = userManager.queryPage(user);
        logger.info("queryPage result =============== "+res.getItems().size());
        return new DataResult<BasePageResponse>(0, "ok", res);
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
