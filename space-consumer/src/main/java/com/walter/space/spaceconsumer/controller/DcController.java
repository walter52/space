package com.walter.space.spaceconsumer.controller;

import com.walter.space.spaceconsumer.feign.UserCenterFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 * @date 2020/2/10 3:17 下午
 */
@RestController
@Slf4j
public class DcController {

    @Autowired
    private UserCenterFeign userCenterFeign;

    @GetMapping("/dc")
    public String dc() {
        return userCenterFeign.dc();
    }
}
