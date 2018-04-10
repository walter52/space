package com.walter.space.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walterwu
 * @date 2018/03/28
 */

@RestController
@RequestMapping("/get")
public class ViewController {
  @Autowired
  private ImageService imageService;

  @RequestMapping("/image")
  public String getImage(){
    return imageService.getImage();
  }
}
