package com.walter.space.console.web.exception;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author walter
 * @date 2020/6/1 11:43 下午
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
public class ErrorInfoBuilder implements HandlerExceptionResolver{

    private ErrorProperties errorProperties;

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        return null;
    }
}
