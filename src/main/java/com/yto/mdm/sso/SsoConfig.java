package com.yto.mdm.sso;

import com.yto.sso.sso.SSOConfig;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 权限系统配置参数
 */
@Configuration
public class SsoConfig  {

//    /**
//     * 获取token的url
//     */
//    @Value("${auth.token.url}")
//    private String tokenUrl;
//
//    /**
//     * 九州分配的appKey
//     */
//    @Value("${auth.appkey}")
//    private String appKey;
//
//    /**
//     * 九州分配的secret
//     */
//    @Value("${auth.appsec}")
//    private String appSec;
//
//    /**
//     * 应用ID
//     */
//    @Value("${auth.psid}")
//    private String psId;
//
//    /**
//     * 获取菜单权限地址
//     */
//    @Value("${auth.menu.url}")
//    private String getMenuByUsernameUrl;
//
//    /**
//     * 获取按钮权限地址
//     */
//    @Value("${auth.button.url}")
//    private String getAllButtonUrl;
//
//
//    @Override
//    public void afterPropertiesSet() {
//        //初始化执行initConfig方法
//        SSOConfig.initConfig(tokenUrl, appKey, appSec, psId, getMenuByUsernameUrl, getAllButtonUrl);
//    }

}
