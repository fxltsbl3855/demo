package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.model.rest.DataResult;
import com.yto.sso.YtoRight;
import com.yto.sso.bo.right.RightResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SSOController {
    private static final Logger logger = LoggerFactory.getLogger(SSOController.class);

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        logger.info("get index invoke...");
        ModelAndView m = new ModelAndView("index");
        String userName = request.getRemoteUser();
        logger.info("username is  {} ",userName);
        RightResp rightResp = YtoRight.getMenuByUsername(userName);
        m.addObject("menus", rightResp.getPermissions());
        return m;
    }

    /**
     * 获取用户菜单
     * @param request
     * @return
     */
    @RequestMapping(value = "/menu")
    @ResponseBody
    public DataResult menu(HttpServletRequest request) {
        logger.info("get menu invoke...");
        String userName = request.getRemoteUser();
        RightResp rightResp = YtoRight.getMenuByUsername(userName);
        DataResult dataResult = new DataResult();
        dataResult.setData(rightResp.getPermissions());
        return dataResult;
    }

    /**
     * 九州单点登录回调接口
     * @return
     */
	@RequestMapping("/ssourl")
    @ResponseBody
    public  void ssourl(HttpServletRequest request, @RequestParam String id_token, HttpServletResponse response, String redirect_url){
        logger.info("ssourl invoke...,id_token = {}, redirect_url = {}",id_token,redirect_url);
	    //TODO 封装token存入redis
    }

    /**
     * 九州单点登出调用接口
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        logger.info("logout invoke...");
	    //TODO 用户登出处理登出业务逻辑
        return "ok";
    }


}
