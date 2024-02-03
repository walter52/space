package com.walter.space.console.model;

import lombok.Data;

import java.util.Date;

@Data
public class AdminResp {
    private String email;  //email
    private String name;  //姓名
    private String remark;  //备注
    /**
     * 角色类型 1:管理员
     */
    private String roleCode;

}
