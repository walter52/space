package com.walter.space.web.controller;

import com.walter.space.constants.Constants;
import com.walter.space.model.Admin;
import com.walter.space.service.AdminService;
import com.walter.space.util.EncryptUtils;
import com.walter.space.util.EncryptUtils.EncryptType;
import com.walter.space.web.result.ResposeResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walterwu
 * @date 2018/04/09
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

  @Autowired
  private AdminService adminService;

  /**
   * 登录接口
   *
   * @param loginEmail 登录邮箱
   * @param loginPwd 登录密码
   * @return 登录结果
   */
  @RequestMapping("/login")
  public ResposeResult login(String loginEmail, String loginPwd, String isRemember) {

    if (StringUtils.isBlank(loginEmail) || StringUtils.isBlank(loginPwd)) {
      return ResposeResult.error("用户名或密码为空！");
    }
    Admin admin = adminService.selectAdminByEmail(loginEmail);
    try {
      if (admin == null) {
        return ResposeResult.error("账户不存在！");
      }

      if ("on".equals(isRemember)) {  //记住密码
        if (!loginPwd.equals(admin.getPassword())) {
          return ResposeResult.error("密码错误！");
        }
      } else {
        if (!EncryptUtils.encrypt(loginPwd, EncryptType.MD5).equals(admin.getPassword())) {
          return ResposeResult.error("密码错误！");
        }
      }

      //登录成功
      request.getSession().setAttribute(Constants.LOGIN_ADMIN_SESSION_KEY, admin);

    } catch (Exception e) {
      LOG.error("系统异常,loginEmail:{},loginPwd:{}", loginEmail, loginPwd);
      return ResposeResult.error("系统异常，请联系管理员");
    }

    return ResposeResult.success(admin);
  }


}
