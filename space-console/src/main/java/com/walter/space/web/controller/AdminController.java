package com.walter.space.web.controller;

import com.walter.space.web.form.LoginForm;
import com.walter.space.web.result.ResposeResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walterwu
 * @date 2018/04/09
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{

    @RequestMapping("/login")
    public ResposeResult login(LoginForm loginForm){
      return null;
    }


}
