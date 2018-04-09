package com.walter.space.web.exception;

/**
 * @author walterwu
 * @date 2018/04/09
 */
public class SignFailException extends RuntimeException{

  public SignFailException() {
    super();
  }

  public SignFailException(String message) {
    super(message);
  }
}
