package com.walter.space.console.service;

import com.walter.space.console.dao.AdminDao;
import com.walter.space.console.model.Admin;
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
   * @param name name
   * @return admin业务对象
   */
  public Admin selectAdminByName(String name) {
    return adminDao.selectAdminByName(name);
  }
}
