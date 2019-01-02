package com.yto.mdm.service.impl;

import net.ytoframework.plugin.zeromq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ZeroMQ发送消息示例
 * 1 注入sender对象
 * 2 调用接口（方法中指定topic）
 * 3 对msg进行处理
 */
//@Service
public class ZeroMqSenderDemo {

    @Autowired
    Sender<String> sender;

    public String send() {
        for (int i = 0; i < 100; i++) {
            boolean b = sender.send("topic2", "msg" + i);
        }
        return "success";
    }

}
