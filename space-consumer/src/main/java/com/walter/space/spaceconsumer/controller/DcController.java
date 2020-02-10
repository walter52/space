package com.walter.space.spaceconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author walter
 * @date 2020/2/10 3:17 下午
 */
@RestController
@Slf4j
public class DcController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/dc")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("space-usercenter");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() +"/usercenter/dc";
        log.info(url);
        return restTemplate.getForObject(url, String.class);
    }
}
