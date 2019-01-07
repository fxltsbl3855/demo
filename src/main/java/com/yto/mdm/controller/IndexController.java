package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.model.rest.DataResult;
import com.yto.mdm.sso.SsoService;
import com.yto.sso.bo.right.RightResp;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Log
@Controller
@RequestMapping("/permission")
public class IndexController {

    @Autowired
    public SsoService ssoService;

    @RequestMapping(value = "/menu" ,method = RequestMethod.POST)
    public DataResult index(HttpServletRequest request) {
        String userName = request.getRemoteUser();
        RightResp rightResp = ssoService.queryRightResp(userName);
        DataResult dataResult = new DataResult();
        dataResult.setData(rightResp.getPermissions());
        return dataResult;
    }

}
