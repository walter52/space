package com.walter.space.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walterwu
 * @date 2018/03/28
 */

@RestController
@RequestMapping("/get")
public class ViewController {

  @RequestMapping("/image")
  public String getImage(){
    return "success";
  }
}
