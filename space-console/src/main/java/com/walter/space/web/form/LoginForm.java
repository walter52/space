package com.walter.space.web.form;

/**
 * @author walterwu
 * @date 2018/04/09
 */
public class LoginForm {

  private String email;
  private String password;
  private Boolean remember; //是否记住登录
  private Boolean useCookie; //是否使用cookie

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getRemember() {
    return remember;
  }

  public void setRemember(Boolean remember) {
    this.remember = remember;
  }

  public Boolean getUseCookie() {
    return useCookie;
  }

  public void setUseCookie(Boolean useCookie) {
    this.useCookie = useCookie;
  }
}
