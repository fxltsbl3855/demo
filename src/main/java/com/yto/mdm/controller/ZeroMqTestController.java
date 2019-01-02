package com.yto.mdm.controller;

import com.yto.mdm.service.impl.ZeroMqSenderDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ZeroMqTestController {

    @Autowired
    ZeroMqSenderDemo sender;

    /**
     * 测试MQ发送接口
     * @return
     */
    @RequestMapping("/send")
    public String send() {
        try{
            return sender.send();
        }catch (Exception e){
            e.printStackTrace();
            return "fail:"+e.getMessage();
        }



    }

}
