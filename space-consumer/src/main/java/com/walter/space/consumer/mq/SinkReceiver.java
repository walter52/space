package com.walter.space.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author walter
 * @date 2020/2/14 12:00 上午
 */
@EnableBinding(Sink.class)
@Slf4j
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object obj) {
        log.info("receive message:{}", obj.toString());
    }
}
