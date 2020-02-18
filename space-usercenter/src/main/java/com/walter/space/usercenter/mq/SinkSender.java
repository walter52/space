package com.walter.space.usercenter.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author walter
 * @date 2020/2/14 12:47 下午
 */
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
