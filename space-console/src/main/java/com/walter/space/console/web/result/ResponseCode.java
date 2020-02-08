package com.walter.space.console.web.result;

/**
 * 响应枚举类
 *
 * @author walterwu
 * @date 2018/04/09
 */
public enum ResponseCode {
  /**
   * 成功
   */
  SUCCESS(200,"Success"),
  /**
   * 页面找不到
   */
  NOT_FOUND(404,"Not Found"),
  /**
   * 服务器错误
   */
  FAILURE(500,"Server Error"),
  /**
   * 无效的请求参数
   */
  INVALID_PARAM(601,"Invalid Param"),
  /**
   * 效验失败
   */
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
