package com.yto.mdm.controller;



import com.yto.mdm.service.impl.ZeroMqServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {
    private static final Logger logger = LoggerFactory.getLogger(ComputeController.class);

    /**
     * 九州单点登录回调接口
     * @return
     */
	@RequestMapping("/ssourl")
    public String ssourl(){
	    //TODO 封装token存入redis
	    return "ok";
    }

    /**
     * 九州单点登出调用接口
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
	    //TODO 用户登出处理登出业务逻辑
        return "ok";
    }


}
