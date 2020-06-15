package com.walter.space.console.web.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

/**
 * @author walter
 * @date 2020/6/1 11:43 下午
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@Getter
@Setter
public class GlobalErrorInfoBuilder implements HandlerExceptionResolver {
    private final static String BASE_ERROR = "base.error";

    private ErrorProperties errorProperties;

    /**
     * 错误构造器
     *
     * @param
     * @return
     */
    public GlobalErrorInfoBuilder(ServerProperties serverProperties) {
        this.errorProperties = serverProperties.getError();
    }

    /**
     * 构建错误信息
     *
     * @param
     * @return
     */
    public GlobalErrorInfo getErrorInfo(HttpServletRequest request,Throwable error) {
        GlobalErrorInfo globalErrorInfo = GlobalErrorInfo.builder()
                .time(LocalDateTime.now().toString())
                .url(request.getRequestURL().toString())
                .error(error.toString())
                .stackTrace()
                .statusCode()
                .reasonPhrase()
                .build();
    }

    /**
     * 获取错误类型
     *
     * @param
     * @return
     */

    private Throwable getError(HttpServletRequest request){
        Throwable error = (Throwable)request.getAttribute(BASE_ERROR);
        if(error == null){
            error = (Throwable) request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE);
        }

    }


    /**
     * 获取通信状态
     *
     * @param request HttpServletRequest
     * @return 通信状态
     */
    public HttpStatus getHttpStatus(HttpServletRequest request){
        Integer status = (Integer)request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
        try {
            return status == null?HttpStatus.INTERNAL_SERVER_ERROR:HttpStatus.valueOf(status);
        }catch (Exception e){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * 获取堆栈轨迹
     *
     * @param error 异常
     * @param flag 表示
     * @return 异常堆栈
     */
    public String getStackTraceInfo(Throwable error,boolean flag){
        if(!flag){
            return "omitted";
        }
        StringWriter trackTrace = new StringWriter();
        error.printStackTrace(new PrintWriter(trackTrace));
        trackTrace.flush();
        return trackTrace.toString();
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        return null;
    }


}
