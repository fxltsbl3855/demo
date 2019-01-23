package com.yto.mdm.sso;

import com.idsmanager.dingdang.jwt.DingdangUserRetriever;
import net.ytoframework.plugin.sso.handler.DefaultJwtPayloadHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomizedJwtPayloadHandler extends DefaultJwtPayloadHandler {

    @Override
    public Map<String, String> payload(DingdangUserRetriever.User u, Map<String, String> more) {
        Map map = super.payload(u, more);
        map.put("code123", "123123");
        return map;
    }

}
