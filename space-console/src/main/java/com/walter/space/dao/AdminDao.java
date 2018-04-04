package com.walter.space.dao;

import com.walter.space.model.Admin;

/**
 * @author walterwu
 * @date 2018/04/04
 */
public interface  AdminDao {
  /**
   * 根据email获取用户
   *
   * @param email email
   * @return admin数据库实例
   */
  Admin selectAdminByEmail(String email);
}
