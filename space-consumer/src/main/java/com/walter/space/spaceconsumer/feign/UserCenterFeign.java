package com.walter.space.spaceconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author walter
 * @date 2020/2/10 9:50 下午
 */
@FeignClient(name ="space-usercenter",path = "/usercenter")
public interface UserCenterFeign {

    @GetMapping("/dc")
    String dc();
}
