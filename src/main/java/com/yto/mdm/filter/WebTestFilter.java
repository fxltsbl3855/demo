package com.yto.mdm.filter;

import com.yto.mdm.controller.SSOController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Filter测试类
 */
@WebFilter(urlPatterns = "/*")
@Order(1)
public class WebTestFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(SSOController.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("LogCostFilter init................");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("LogCostFilter doFilter................");
        long start = System.currentTimeMillis();
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        String url = httpRequest.getRequestURI();
        //TODO 拦截url，并做相应业务处理逻辑

        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("Execute cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        logger.info("LogCostFilter destroy................");
    }
}
