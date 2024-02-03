package com.walter.space.console.dao;

import com.walter.space.console.model.Admin;

/**
 * @author walterwu
 * @date 2018/04/04
 */
public interface AdminDao {

  /**
   * 根据email获取用户
   *
   * @param email email
   * @return admin业务对象
   */
  Admin selectAdminByName(String email);

  /**
   * 添加新的用户
   *
   * @param admin 管理员业务对象
   */
  void add(Admin admin);
}
