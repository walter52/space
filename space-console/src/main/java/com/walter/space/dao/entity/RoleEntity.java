package com.walter.space.dao.entity;

import java.util.Date;
import java.util.List;

/**
 * 角色业务模型
 * @author walterwu
 * @date 2018/04/01
 */
public class RoleEntity {

  private Integer id; //id
  private String name;  //角色名称
  private String code; //角色代码
  private Integer level = 1;  //级别，值越大，级别越高
  private List<String> menuCodes; //菜单代码
  private String remark; //备注
  private String status; //状态
  private String createdBy;  //创建人
  private Date createdOn; //创建时间
  private String lastChangedBy; //最后修改人
  private String lastChangedOn;  //最后修改时间

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public List<String> getMenuCodes() {
    return menuCodes;
  }

  public void setMenuCodes(List<String> menuCodes) {
    this.menuCodes = menuCodes;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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
