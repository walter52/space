package com.walter.space.console.model;

import java.util.Date;

/**
 * 用户
 *
 * @author walterwu
 * @date 2018/04/01
 */
public class Admin {

  private Integer id; //id
  private String email;  //email
  private String password;  //密码
  private String name;  //姓名
  private String remark;  //备注
  private String createdBy;  //创建人
  private Date createdOn;  //创建时间
  private String lastChangedBy;  //最后修改人
  private String lastChangedOn;  //最后修改时间


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public String getLastChangedBy() {
    return lastChangedBy;
  }

  public void setLastChangedBy(String lastChangedBy) {
    this.lastChangedBy = lastChangedBy;
  }

  public String getLastChangedOn() {
    return lastChangedOn;
  }

  public void setLastChangedOn(String lastChangedOn) {
    this.lastChangedOn = lastChangedOn;
  }
}
