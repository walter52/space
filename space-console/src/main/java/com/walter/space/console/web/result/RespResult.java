package com.walter.space.console.web.result;

/**
 * Json结果
 *
 * @author walterwu
 * @date 2018/04/09
 */
public class RespResult {

  private Integer code;
  private String msg;
  private Object data;

  public RespResult() {
  }

  public RespResult(Integer code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public static RespResult success(Object data) {
    return new RespResult(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getMsg(), data);
  }

  public static RespResult success(String msg, Object data) {
    return new RespResult(RespCode.SUCCESS.getCode(), msg, data);
  }

  public static RespResult error(String msg) {
    return new RespResult(RespCode.FAILURE.getCode(), msg, null);
  }

  public static RespResult error(RespCode respCode) {
    return new RespResult(respCode.getCode(), respCode.getMsg(), null);
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
