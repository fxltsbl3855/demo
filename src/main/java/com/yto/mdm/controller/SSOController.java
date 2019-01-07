package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.model.rest.DataResult;
import com.yto.sso.YtoRight;
import com.yto.sso.bo.right.RightResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SSOController {
    private static final Logger logger = LoggerFactory.getLogger(SSOController.class);

    /**
     * 获取用户菜单
     * @param request
     * @return
     */
    @RequestMapping(value = "/permission/menu" ,method = RequestMethod.POST)
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
    public String ssourl(){
        logger.info("ssourl invoke...");
	    //TODO 封装token存入redis
	    return "ok";
    }

    /**
     * 九州单点登出调用接口
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        logger.info("logout invoke...");
	    //TODO 用户登出处理登出业务逻辑
        return "ok";
    }


}
