package com.yto.mdm.service.impl;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import net.ytoframework.plugin.zeromq.MessageCallback;
import net.ytoframework.plugin.zeromq.Subscriber;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * ZeroMQ监听消息示例
 * 1 加注解Subscriber，并配置topic和线程数参数
 * 2 实现MessageCallback并重写onMessage方法
 * 3 在onMessage中实现业务逻辑
 *
 * @author admin
 */
@Log
//@Subscriber(topic = "topic2", threadSize = 10)
public class ZeroMqReceicerDemo implements MessageCallback<String> {

    @Override
    public void onMessage(String p) {
        log.info(Thread.currentThread().getName() + " msg: " + p);

        //TODO 处理业务逻辑

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
