package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.model.rest.DataResult;
import com.yto.sso.YtoRight;
import com.yto.sso.bo.right.RightResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SSOController {
    private static final Logger logger = LoggerFactory.getLogger(SSOController.class);

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView m = new ModelAndView("index");
        logger.info("get index invoke...");
//        String userName = request.getRemoteUser();
        String userName = "01589572";
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
    public  String ssourl(){
        logger.info("ssourl invoke...");
	    //TODO 封装token存入redis
	    return "ok";
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
