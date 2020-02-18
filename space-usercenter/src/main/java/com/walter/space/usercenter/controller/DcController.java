package com.walter.space.usercenter.controller;

import com.walter.space.usercenter.mq.SinkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 * @date 2020/2/10 2:48 下午
 */
@RestController
public class DcController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private SinkSender sinkSender;

    @GetMapping("/dc")
    public String dc() throws Exception{
        String service = discoveryClient.getServices().toString();
        Thread.sleep(5000L);
        return service;
    }

    @GetMapping("/send")
    public String send(){
        sinkSender.output().send(MessageBuilder.withPayload("hello,2342").build());
        return "OK";
    }

}
