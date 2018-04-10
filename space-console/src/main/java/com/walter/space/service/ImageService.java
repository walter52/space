package com.walter.space.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author walterwu
 * @date 2018/03/29
 */
@Service
public class ImageService{
  @Value("${image.name}")
  private String name;
  @Value("${image.url}")
  private String url;

  public String getImage(){
    return "image name:"+name+",url:"+url;
  }
}
