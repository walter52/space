package com.walter.space.web.controller;

import com.walter.space.web.exception.ParamsException;
import com.walter.space.web.exception.SignFailException;
import com.walter.space.web.result.ResponseCode;
import com.walter.space.web.result.ResposeResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一处理接口异常
 *
 * @author walterwu
 * @date 2018/04/09
 */
public abstract class BaseController {

  protected Logger LOG = LoggerFactory.getLogger(getClass());

  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public ResposeResult handleException(Exception e,HttpServletRequest request){
    ResposeResult resposeResult;
    if(e instanceof ParamsException){
      resposeResult = ResposeResult.error(ResponseCode.INVALID_PARAM);
    }else if(e instanceof SignFailException){
      resposeResult = ResposeResult.error(ResponseCode.SIGN_ERROR);
    }else {
      resposeResult = ResposeResult.error(ResponseCode.FAILURE);
    }
    LOG.error("=====================");
    LOG.error(request.getRequestURI(),e);
    LOG.error("=====================");
    return resposeResult;
  }
}
