package com.walter.space.web.result;

/**
 * @author walterwu
 * @date 2018/04/09
 */
public enum ResponseCode {
  SUCCESS(200,"Success"),
  NOT_FOUND(404,"Not Found"),
  FAILURE(500,"Server Error"),
  INVALID_PARAM(601,"Invalid Param"),
  SIGN_ERROR(602,"sign error");

  private Integer code;
  private String msg;

  ResponseCode(Integer code,String msg){
    this.code = code;
    this.msg = msg;
  }

  public Integer getCode(){
    return this.code;
  }

  public String getMsg(){
    return this.msg;
  }
}
