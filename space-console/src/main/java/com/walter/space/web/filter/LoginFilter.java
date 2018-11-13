package com.walter.space.web.filter;

import com.walter.space.constants.Constants;
import com.walter.space.model.Admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 登录过滤器
 *
 * @author walterwu
 * @date 2018/03/30
 */
@Component
public class LoginFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String uri = httpServletRequest.getRequestURI();
        if (uri.contains("/assets/")
            || uri.contains("/js/")
            || uri.contains("/login.html")
            || uri.contains("/admin/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Admin loginAdmin =
                (Admin) httpServletRequest.getSession().getAttribute(Constants.LOGIN_ADMIN_SESSION_KEY);
            //已登录
            if (loginAdmin != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                String loginUrl = httpServletRequest.getContextPath() + "/login.html";
                // 处理Ajax请求
                if (httpServletRequest.getHeader("x-requested-with") != null
                    && "XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("x-requested-with"))) {
                    // 向HTTP头添加会话状态sessionStatus
                    httpServletResponse.setHeader("sessionStatus", "timeout");
                    httpServletResponse.setStatus(403);
                    //向HTTP头添加登录的URL
                    httpServletResponse.addHeader("loginUrl", loginUrl);
                    LOG.debug("拦截Ajax请求");
                } else {
                    httpServletResponse.sendRedirect(loginUrl);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
