package com.std.springboot.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义过滤器 需要实现Filter
 * <p>
 * **** 过滤器的顺序问题：
 * 使用FilterRegistrationBean实现
 *
 * @author zhaojy
 * @date 2019-03-18
 */
@WebFilter(urlPatterns = {"/*"}, filterName = "customerFilter")
@Slf4j
public class CustomerFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    /**
     * 过滤器
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
            IOException, ServletException {
        log.info("-----------");
        servletRequest.setAttribute("attrId", "filter put 123123");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
