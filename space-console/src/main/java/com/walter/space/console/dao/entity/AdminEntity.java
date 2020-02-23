package com.walter.space.console.dao.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
 * 用户
 *
 * @author walterwu
 * @date 2018/04/01
 */

@Data
@Table(name = "space_console_admin")
public class AdminEntity {

  /**
   * id
   */
  private Integer id;

  /**
   * email
   */
  private String email;

  /**
   * 密码
   */
  private String password;

  /**
   * 姓名
   */
  private String name;

  /**
   * 备注
   */
  private String remark;

  /**
   * 创建人
   */
  private String createdBy;

  /**
   * id
   */
  private Date createdOn;

  /**
   * 修改人
   */
  private String lastChangedBy;

  /**
   * 修改时间
   */
  private String lastChangedOn;

}
