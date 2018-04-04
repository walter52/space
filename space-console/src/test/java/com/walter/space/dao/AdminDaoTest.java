package com.walter.space.dao;

import com.walter.space.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author walterwu
 * @date 2018/04/04
 */
public class AdminDaoTest extends BaseTest{
  @Autowired
  private AdminDao adminDao;
  @Test
  public void testGetAdmin(){
    adminDao.selectAdminByEmail("walter52@sohu.com");

  }
}
