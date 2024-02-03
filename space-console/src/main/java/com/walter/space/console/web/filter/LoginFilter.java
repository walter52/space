package com.walter.space.console.web.filter;

import com.walter.space.console.constants.Constants;
import com.walter.space.console.model.Admin;
import com.walter.space.console.model.AdminResp;
import com.walter.space.console.web.exception.SignFailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            || uri.contains("/register.html")
            || uri.contains("/admin/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            AdminResp loginAdmin =
                (AdminResp) httpServletRequest.getSession().getAttribute(Constants.LOGIN_ADMIN_SESSION_KEY);
            //已登录
            if (loginAdmin != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
               throw new SignFailException("请登录");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
