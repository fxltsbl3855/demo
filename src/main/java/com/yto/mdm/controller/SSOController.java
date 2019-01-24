package com.yto.mdm.controller;

import cn.com.yto56.basic.framework.core.util.JsonUtil;
import cn.com.yto56.basic.framework.model.rest.DataResult;
import com.yto.sso.YtoRight;
import com.yto.sso.bo.right.RightResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Controller
public class SSOController {

    private static final Logger logger = LoggerFactory.getLogger(SSOController.class);

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView m = new ModelAndView("index");
        logger.info("get index invoke...");
//        String userName = request.getRemoteUser();
        String userName = "01589572";
        RightResp rightResp = YtoRight.getMenuByUsername(userName);
        m.addObject("menus", rightResp.getPermissions());
        return m;
    }

    /**
     * 获取用户菜单
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/menu")
    @ResponseBody
    public DataResult menu(HttpServletRequest request) {
        logger.info("get menu invoke...");
        String userName = request.getRemoteUser();
        RightResp rightResp = YtoRight.getMenuByUsername(userName);
        DataResult dataResult = new DataResult();
        dataResult.setData(rightResp.getPermissions());
        return dataResult;
    }

    /**
     * 九州单点登出调用接口
     *
     * @return
     */
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request) {
        logger.info("logout invoke...");
    }

    private void responseOutWithJson(HttpServletResponse response, DataResult result) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JsonUtil.bean2Json(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
