package com.walter.space.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author walter
 * @date 2020/2/10 9:50 下午
 */
@FeignClient(name = "space-usercenter", path = "/usercenter", fallback = UserCenterFeignFallback.class)
public interface UserCenterFeign {

    @GetMapping("/dc")
    String dc();
}

@Component
class UserCenterFeignFallback implements UserCenterFeign {
    @Override
    public String dc() {
        return "访问异常";
    }
}
