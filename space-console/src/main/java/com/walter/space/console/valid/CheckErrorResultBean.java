package com.walter.space.console.valid;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author walter
 * @date 2020/8/31 12:05 上午
 */
@Data
@AllArgsConstructor
public class CheckErrorResultBean {
    private String property;
    private String message;
}
