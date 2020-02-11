package com.walter.space.consumer.controller;

import com.walter.space.consumer.feign.UserCenterFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private DcService dcService;


    @GetMapping("/dc")
    public String dc() {
        return dcService.toDc();
    }
}

@Service
class  DcService{

    @Autowired
    private UserCenterFeign userCenterFeign;

//    @HystrixCommand(fallbackMethod = "fallback")
    public String toDc(){
        return userCenterFeign.dc();
    }

    public String fallback(){
        return "hystrix 服务熔断";
    }
}
