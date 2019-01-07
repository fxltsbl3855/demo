package com.yto.mdm.service.impl;

import com.yto.mdm.constant.Constant;
import com.yto.mdm.service.ZeroMqService;
import net.ytoframework.plugin.zeromq.MessageCallback;
import net.ytoframework.plugin.zeromq.Sender;
import net.ytoframework.plugin.zeromq.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * ZeroMQ发送消息步骤
 *          1 注入sender对象，
 *          2 调用接口（方法中指定topic）
 *          3 对msg进行处理
 * ZeroMQ监听消息示例
 *          1 加注解Subscriber，并配置topic和线程数参数，
 *          2 实现MessageCallback并重写onMessage方法，
 *          3 在onMessage中实现业务逻辑
 */
//@Service
//@Subscriber(topic = "topic2", threadSize = 10)
public class ZeroMqServiceImpl implements MessageCallback<String>, ZeroMqService {
    private static final Logger logger = LoggerFactory.getLogger(ZeroMqServiceImpl.class);

    @Autowired
    Sender<String> sender;

    /**
     * 发送消息
     * @return
     */
    @Override
    public boolean send(String msg) {
        return sender.send(Constant.MQ_TOPIC_MDM_MODULE, msg);
    }

    /**
     * 监听消息方法实现
     * @param p
     */
    @Override
    public void onMessage(String p) {
        logger.info(" msg: " + p);

        //TODO 处理业务逻辑

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
