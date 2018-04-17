package com.walter.space.web.controller;

import com.walter.space.model.Admin;
import com.walter.space.service.AdminService;
import com.walter.space.web.form.LoginForm;
import com.walter.space.web.result.ResposeResult;
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

    @RequestMapping("/login")
    public ResposeResult login(LoginForm loginForm) {
        ResposeResult result = new ResposeResult();
        Admin admin =adminService.selectAdminByEmail(loginForm.getEmail());
        if (loginForm.getUseCookie()) {
            if(admin !=null && !admin.getPassword().equals(loginForm.getPassword())){

            }
        }
        return null;
    }


}
