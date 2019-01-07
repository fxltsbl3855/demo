package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.model.rest.DataResult;
import com.yto.mdm.service.ZeroMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ZeroMqTestController {

    @Autowired
    ZeroMqService zeroMqService;

    /**
     * 测试MQ发送接口
     * @return
     */
    @RequestMapping("/send")
    public String send(String msg) {
        try{
            boolean res = zeroMqService.send(msg);
            return res ? DataResult.ok().getMessage():"send msg fail";
        }catch (Exception e){
            e.printStackTrace();
            return "fail:"+e.getMessage();
        }



    }

}
