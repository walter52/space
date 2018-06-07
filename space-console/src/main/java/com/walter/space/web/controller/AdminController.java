package com.walter.space.web.controller;

import com.walter.space.constants.Constants;
import com.walter.space.model.Admin;
import com.walter.space.service.AdminService;
import com.walter.space.util.MD5Util;
import com.walter.space.web.form.LoginForm;
import com.walter.space.web.result.ResposeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;

/**
 * @author walterwu
 * @date 2018/04/09
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

  private static final String ADMIN_COOKIE_EMAIL = "waem"; //cookies email
  private static final String ADMIN_COOKIE_PASSWORD = "wapd"; //coolies passwrod
  private static final String ADMIN_COOKIE_PWD_PATH = "/"; //cookies password path
  @Autowired
  private AdminService adminService;

  @RequestMapping("/login")
  public ResposeResult login(LoginForm loginForm) {
    ResposeResult  resposeResult;
    try {
      Admin admin = adminService.selectAdminByEmail(loginForm.getEmail());
      if (loginForm.getUseCookie()) {
        if (admin != null && !admin.getPassword().equals(loginForm.getPassword())) {
          //admin 存在但是cookies密码错误
          Cookie cookie = new Cookie(ADMIN_COOKIE_PASSWORD, null);
          cookie.setPath(ADMIN_COOKIE_PWD_PATH);
          cookie.setMaxAge(0); //不记录cookies
          response.addCookie(cookie);
          admin = null;
        }
      } else {
        if (admin != null && !admin.getPassword()
            .equals((MD5Util.MD5Encode(loginForm.getPassword())))) {
          //admin 存在但是密码错误
          admin = null;
        }
      }

      if (admin != null) {
        if(Constants.STATUS_UNAVAILABLE.equals(admin.getStatus())){
          resposeResult = ResposeResult.error("账户不可用！");
          LOG.error("账户不可用:{}",loginForm.getEmail());
        }
      }
    } catch (Exception e) {

    }
    return null;
  }


}
