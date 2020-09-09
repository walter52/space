package com.walter.space.console.valid;

import java.lang.annotation.*;

/**
 * @author walter
 * @date 2020/8/30 11:50 下午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidParam {

    /**
     * 参数效验对象
     */
    Class<?>[] value() default {};

    /**
     * 效验分组
     */
    Class<?>[] group() default {};
}
