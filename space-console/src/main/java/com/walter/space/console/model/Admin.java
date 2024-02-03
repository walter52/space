package com.walter.space.console.model;

import lombok.Data;

import java.util.Date;

/**
 * 用户
 *
 * @author walterwu
 * @date 2018/04/01
 */
@Data
public class Admin {

    private Integer id; //id  private Integer id; //id
    private String email;  //email
    private String password;  //密码
    private String name;  //姓名
    private String remark;  //备注
    /**
     * 角色类型 1:管理员
     */
    private String roleCode;

    private String createdBy;  //创建人
    private Date createdOn;  //创建时间
    private String lastChangedBy;  //最后修改人
    private String lastChangedOn;  //最后修改时间
}
