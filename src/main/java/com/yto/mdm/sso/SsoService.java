package com.yto.mdm.sso;

import com.yto.sso.YtoRight;
import com.yto.sso.bo.right.Permission;
import com.yto.sso.bo.right.RightResp;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
@Log
public class SsoService {

    /**
     * 获取用户菜单
     *
     * @param username
     * @return
     */
    public RightResp queryRightResp(String username) {
        //使用
        RightResp r= YtoRight.getMenuByUsername(username);
        return r;
    }

}
