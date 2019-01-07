package com.yto.mdm.service.impl;

import cn.com.yto56.basic.framework.plugin.redis.ops.*;
import com.yto.mdm.service.RedisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis如何使用操作类
 * 1 引入操作对象
 * 2 执行对应接口进行操作
 */
@Service
public class RedisDemoServiceImpl implements RedisDemoService {

    @Autowired
    KeyValueOps keyValueOps;

    public void test() {
        keyValueOps.set("de", "key", "value", 100, TimeUnit.SECONDS);
        keyValueOps.get("de", "key").toString();
    }

}
