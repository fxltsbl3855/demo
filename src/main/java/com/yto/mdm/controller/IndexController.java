package com.yto.mdm.controller;

import com.yto.mdm.sso.SsoService;
import com.yto.sso.bo.right.RightResp;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Log
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    public SsoService ssoService;

    @RequestMapping
    public ModelAndView index(HttpServletRequest request) {
        String userName = request.getRemoteUser();
        log.info("-------- " + userName);
        ModelAndView mv = new ModelAndView("index");
        if(userName == null || "".equals(userName.trim())){
            return mv;
        }
        RightResp rightResp = ssoService.queryRightResp(userName);
        mv.addObject("menus", rightResp.getPermissions());
        return mv;
    }

}
