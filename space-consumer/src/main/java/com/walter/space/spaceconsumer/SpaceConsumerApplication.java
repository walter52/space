package com.walter.space.spaceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class SpaceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceConsumerApplication.class, args);
    }

}
