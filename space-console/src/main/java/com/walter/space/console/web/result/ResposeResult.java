package com.walter.space.console.web.result;

/**
 * Json结果
 *
 * @author walterwu
 * @date 2018/04/09
 */
public class ResposeResult {

  private Integer code;
  private String msg;
  private Object data;

  public ResposeResult() {
  }

  public ResposeResult(Integer code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public static ResposeResult success(Object data) {
    return new ResposeResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
  }

  public static ResposeResult success(String msg, Object data) {
    return new ResposeResult(ResponseCode.SUCCESS.getCode(), msg, data);
  }

  public static ResposeResult error(String msg) {
    return new ResposeResult(ResponseCode.FAILURE.getCode(), msg, null);
  }

  public static ResposeResult error(ResponseCode responseCode) {
    return new ResposeResult(responseCode.getCode(), responseCode.getMsg(), null);
  }


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
