package com.walter.space.console.web.exception;

import com.walter.space.console.web.result.RespCode;
import com.walter.space.console.web.result.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一处理接口异常
 *
 * @author walterwu
 * @date 2018/04/09
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ParamsException.class)
    public RespResult paramsExceptionHandler(ParamsException e, HttpServletRequest request) {
        printErrorInfo(e,request);
        return RespResult.error(RespCode.INVALID_PARAM);
    }

    @ResponseBody
    @ExceptionHandler(SignFailException.class)
    public RespResult signFailExceptionHandler(SignFailException e,HttpServletRequest request){
      printErrorInfo(e,request);
      return RespResult.error(RespCode.SIGN_ERROR);
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RespResult exceptionHandler(Exception e, HttpServletRequest request) {
        printErrorInfo(e,request);
        return RespResult.error(RespCode.FAILURE);
    }

    private <T extends Exception> void printErrorInfo(T e, HttpServletRequest request) {
        log.error("=====================");
        log.error(request.getRequestURI(), e);
        log.error("=====================");

    }
}
