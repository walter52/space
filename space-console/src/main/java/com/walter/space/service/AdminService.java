package com.walter.space.service;

import com.walter.space.dao.AdminDao;
import com.walter.space.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author walterwu
 * @date 2018/04/10
 */
@Service
public class AdminService {

  @Autowired
  private AdminDao adminDao;


  public void add(Admin admin) throws Exception {
    String defaultPassword = admin.getEmail().substring(0, admin.getEmail().indexOf("@"));
    admin.setPassword(defaultPassword);
    adminDao.add(admin);
  }

  /**
   * 根据email获取用户
   *
   * @param email email
   * @return admin业务对象
   */
  public Admin selectAdminByEmail(String email) {
    return adminDao.selectAdminByEmail(email);
  }
}
