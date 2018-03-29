package com.walter.space.service.impl;

import com.walter.space.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author walterwu
 * @date 2018/03/29
 */
@Configuration
public class ImageServiceImpl implements ImageService{
  @Value("${image.name}")
  private String name;
  @Value("${image.url}")
  private String url;

  public String getImage(){
    return "image name:"+name+",url:"+url;
  }
}
