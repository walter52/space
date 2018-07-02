package com.walter.space.web.controller;

import com.walter.space.constants.Constants;
import com.walter.space.model.Admin;
import com.walter.space.service.AdminService;
import com.walter.space.util.MD5Util;
import com.walter.space.web.form.LoginForm;
import com.walter.space.web.result.ResposeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
  private static final String ADMIN_COOKIE_PATH = "/"; //cookies password path
  @Autowired
  private AdminService adminService;
  @Value("${client.cookie.max-age}")
  private int cookieMaxAge;

  @RequestMapping("/login")
  public ResposeResult login(LoginForm loginForm) {
    ResposeResult resposeResult;
    try {
      Admin admin = adminService.selectAdminByEmail(loginForm.getEmail());
      if (loginForm.getUseCookie()) {
        if (admin != null && !admin.getPassword().equals(loginForm.getPassword())) {
          //admin 存在但是cookies密码错误
          response.addCookie(setCookie(ADMIN_COOKIE_PASSWORD, null, ADMIN_COOKIE_PATH, 0));
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
        if (Constants.STATUS_UNAVAILABLE.equals(admin.getStatus())) {
          resposeResult = ResposeResult.error("账户不可用！");
          LOG.error("账户不可用:{}", loginForm.getEmail());
        } else {
          request.getSession().setAttribute(Constants.LOGIN_ADMIN_SESSION_KEY, admin);
          response.addCookie(
              setCookie(ADMIN_COOKIE_EMAIL, admin.getEmail(), ADMIN_COOKIE_PATH, cookieMaxAge));
          if (loginForm.getUseCookie()) {
            response.addCookie(
                setCookie(ADMIN_COOKIE_PASSWORD, admin.getPassword(), ADMIN_COOKIE_PATH,
                    cookieMaxAge));
          }
          LOG.info("{}:登录成功", admin.getEmail());
          resposeResult = ResposeResult.success("登录成功");
        }
      } else {
        LOG.error("{}:登录失败，密码错误或cookies错误", loginForm.getEmail());
        resposeResult = ResposeResult.error("登录失败，请检查密码！");

      }
    } catch (Exception e) {
      LOG.error("{}:系统异常", loginForm.getEmail());
      resposeResult = ResposeResult.error("系统异常，请联系管理员");
    }
    return resposeResult;
  }

  /**
   * 根据email获取用户
   *
   * @param key cookies key
   * @param value cookie value
   * @param path cookie path
   * @param maxAge cookie过期日期（0：不保存，-1：会话级）
   * @return Cookie 对象
   */
  private Cookie setCookie(String key, String value, String path, int maxAge) {
    Cookie cookie = new Cookie(key, value);
    cookie.setPath(path);
    cookie.setMaxAge(maxAge);
    return cookie;
  }


}
