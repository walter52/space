package com.walter.space.console.web.controller;

import com.walter.space.console.constants.Constants;
import com.walter.space.console.model.AdminResp;
import com.walter.space.console.service.AdminService;
import com.walter.space.console.util.EncryptUtils;
import com.walter.space.console.model.Admin;
import com.walter.space.console.web.result.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author walterwu
 * @date 2018/04/09
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

  @Autowired
  private AdminService adminService;

  /**
   * 登录接口
   *
   * @param loginName 登录邮箱
   * @param loginPwd 登录密码
   * @param isRemember 记住密码
   * @return 登录结果
   */
  @GetMapping("/login")
  public RespResult login(HttpServletRequest request, String loginName, String loginPwd, boolean isRemember) {

    if (StringUtils.isBlank(loginName) || StringUtils.isBlank(loginPwd)) {
      return RespResult.error("用户名或密码为空！");
    }
    Admin admin = adminService.selectAdminByName(loginName);
    AdminResp adminresp = new AdminResp();
    try {
      if (admin == null) {
        return RespResult.error("账户不存在！");
      }

      //记住密码
      if (isRemember) {
        if (!loginPwd.equals(admin.getPassword())) {
          return RespResult.error("密码错误！");
        }
      } else {
        if (!EncryptUtils.encrypt(loginPwd, EncryptUtils.EncryptType.MD5).equals(admin.getPassword())) {
          return RespResult.error("密码错误！");
        }
      }

      BeanUtils.copyProperties(admin,adminresp);

      //登录成功
      request.getSession().setAttribute(Constants.LOGIN_ADMIN_SESSION_KEY, adminresp);

    } catch (Exception e) {
      log.error("系统异常,loginEmail:{},loginPwd:{}", loginName, loginPwd);
      return RespResult.error("系统异常，请联系管理员");
    }

    return RespResult.success(adminresp);
  }

  /**
   * 注销登录接口
   */
  @GetMapping("/logout")
  public RespResult logout(HttpServletRequest request) {
    try {
      request.getSession().setAttribute(Constants.LOGIN_ADMIN_SESSION_KEY, null);
    } catch (Exception e) {
      log.error("登出失败", e);
      return RespResult.error("登出失败！");
    }
    return RespResult.success("登出成功！", request.getContextPath() + "/login.html");
  }

  /**
   * 注册接口
   * @param registerName 注册名称
   * @param registerEmail 注册邮箱
   * @param registerPwd 注册密码
   */
  @GetMapping("/register")
  public RespResult register(String registerName, String registerEmail, String registerPwd) {
    if (StringUtils.isBlank(registerName) || StringUtils.isBlank(registerEmail) || StringUtils
        .isBlank(registerPwd)) {
      return RespResult.error("注册信息不完整！");
    }
    return null;
  }

   @GetMapping("/check")
  public RespResult check() {
    return RespResult.success(true);
  }


}
