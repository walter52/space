package com.walter.space.console.dao;

import com.walter.space.console.BaseTest;
import com.walter.space.console.dao.entity.AdminEntity;
import com.walter.space.console.dao.mapper.AdminMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author walterwu
 * @date 2018/04/04
 */
public class AdminDaoTest extends BaseTest{
  @Autowired
  private AdminMapper adminMapper;
  @Test
  public void testGetAdmin(){
    adminMapper.selectAdminByEmail("walter52@sohu.com");
  }

  @Test
  public void testGetAdmin2(){
    AdminEntity adminEntity = adminMapper.selectByEmail("walter52@sohu.com");
    log.info(adminEntity.getName());
  }

  @Test
  public void addTest(){
    AdminEntity adminEntity = new AdminEntity();
    int count = adminMapper.selectCount(adminEntity);
  }

}
