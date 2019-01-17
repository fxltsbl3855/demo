package com.yto.mdm.service.impl;

import cn.com.yto56.basic.framework.plugin.redis.ops.*;
import com.yto.mdm.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis如何使用操作类
 * 1 引入操作对象
 * 2 执行对应接口进行操作
 */
@Service
public class RedisTestServiceImpl implements RedisTestService {

    @Autowired
    KeyValueOps keyValueOps;

    public void set(String key,String value) {
        keyValueOps.set("de", key, value, 100, TimeUnit.SECONDS);
    }

    public String get(String key) {
        return keyValueOps.get("de", key).toString();
    }
}
