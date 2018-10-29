package com.walter.space.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walterwu
 * @date 2018/03/30
 */
@Controller
public class IndexController {

  @RequestMapping("/")
  public String index(){
    return "forward:/login.html";
  }

}
