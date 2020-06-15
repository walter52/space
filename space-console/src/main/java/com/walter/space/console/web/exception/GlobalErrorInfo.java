package com.walter.space.console.web.exception;

import lombok.Builder;
import lombok.Data;

/**
 * @author walter
 * @date 2020/6/3 10:04 下午
 */
@Data
@Builder
public class GlobalErrorInfo {
    /**
     * 发生时间
     */
    private String time;

    /**
     * url
     */
    private String url;

    /**
     * 错误类型
     */
    private String error;

    /**
     * 错误堆栈信息
     */
    private String stackTrace;

    /**
     * 状态码
     */
    private int statusCode;

    /**
     * 错误原因
     */
    private String reasonPhrase;
}
