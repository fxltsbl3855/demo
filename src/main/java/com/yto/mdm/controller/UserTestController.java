package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.core.util.JsonUtil;
import cn.com.yto56.basic.framework.core.util.ObjectUtil;
import cn.com.yto56.basic.framework.model.rest.*;
import com.yto.mdm.manager.UserTestManager;
import com.yto.mdm.mybatis.datasource1.entity.User;
import com.yto.mdm.mybatis.datasource2.entity.UserInfo;
import com.yto.mdm.vo.UserInfoVo;
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
    public UserTestManager userManager;

    @RequestMapping
    public ModelAndView index() {
        return new ModelAndView("user");
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        logger.info("test method invoked...");
        return "ook";
    }

    @RequestMapping("/setRedis")
    @ResponseBody
    public String setRedis(String key,String value) {
        logger.info("setRedis method invoked...");
        userManager.setRedis(key,value);
        return "set ok";
    }

    @RequestMapping("/getRedis")
    @ResponseBody
    public String getRedis(String key) {
        logger.info("getRedis method invoked...");
        return userManager.getRedis(key);
    }

    /**
     * 根据条件查询用户
     *
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public DataResult<BasePageResponse> queryPage(UserVo userInfo) {
        BasePageResponse<User>  res = userManager.queryPage(userInfo);

        BasePageResponse<UserInfo>  res2 = userManager.queryPageFromDS2(new UserInfoVo());
        logger.info("queryPage result from datasource2,{}", JsonUtil.bean2Json(res2.getItems()));

        logger.info("queryPage result from datasource1, {} " , JsonUtil.bean2Json(res.getItems()));
        return new DataResult<BasePageResponse>(0, "ok", res);
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
