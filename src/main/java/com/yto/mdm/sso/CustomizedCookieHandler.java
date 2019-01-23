package com.yto.mdm.sso;

import lombok.extern.slf4j.Slf4j;
import net.ytoframework.plugin.sso.base.SsoProperties;
import net.ytoframework.plugin.sso.handler.CookieHandler;
import net.ytoframework.plugin.sso.handler.DefaultCookieHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class CustomizedCookieHandler extends DefaultCookieHandler {

    @Override
    public Cookie addcookie(HttpServletResponse response, String token) {
        Cookie cookie = super.addcookie(response, token);
        cookie.setHttpOnly(true);
        return cookie;
    }
}
