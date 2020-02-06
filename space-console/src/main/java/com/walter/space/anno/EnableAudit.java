package com.walter.space.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用审计日志工具类
 *
 * @author walter
 * @date 2020/2/6 1:00 下午
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EnableAudit {


    /**
     * 模块代码
     */
    int moudleCode() default -1;

    /**
     *扩展信息，用户放回的操作类型及参数
     */
    Class<?> extension();
}



