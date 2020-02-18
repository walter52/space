package com.walter.space.common.mq.bean;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * space 自定义消息通道接口
 *
 * @author walter
 * @date 2020/2/18 9:57 下午
 */
public interface SpaceProcessor {

    /**
     * 日志输入通道名称
     */
    String LOG_INPUT = "log_input";

    /**
     * 日志输出通道名称
     */
    String LOG_OUTPUT = "log_output";

    /**
     * 格式化日志输入通道名称
     */
    String FORMAT_LOG_INPUT = "format_log_input";

    /**
     * 格式化日志输出通道名称
     */
    String FORMAT_LOG_OUTPUT = "format_log_output";

    /**
     * @return 日志输入通道
     */
    @Input(SpaceProcessor.LOG_INPUT)
    SubscribableChannel logInput();

    /**
     * @return 日志输出通道
     */
    @Output(SpaceProcessor.LOG_OUTPUT)
    MessageChannel logOutput();

    /**
     * @return 格式化日志输入通道
     */
    @Input(SpaceProcessor.FORMAT_LOG_INPUT)
    SubscribableChannel formatLogInput();

    /**
     * @return 格式化日志输出通道
     */
    @Output(SpaceProcessor.FORMAT_LOG_OUTPUT)
    MessageChannel formatLogOutput();

}
