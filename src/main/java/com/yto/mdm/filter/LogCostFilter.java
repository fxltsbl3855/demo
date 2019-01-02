package com.yto.mdm.filter;

import lombok.extern.java.Log;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Filter测试类
 */
@Log
public class LogCostFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LogCostFilter init................");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("LogCostFilter doFilter................");
        long start = System.currentTimeMillis();
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;

        //TODO 拦截url，并做相应业务处理逻辑

        filterChain.doFilter(servletRequest,servletResponse);
        log.info("Execute cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        log.info("LogCostFilter destroy................");
    }
}
