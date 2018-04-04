package com.walter.space.dao.impl;

import com.walter.space.dao.AdminDao;
import com.walter.space.dao.entity.AdminEntity;
import com.walter.space.dao.mapper.AdminMapper;
import com.walter.space.model.Admin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author walterwu
 * @date 2018/04/04
 */
@Repository
public class AdminDaoImpl implements AdminDao {
  @Autowired
  private AdminMapper adminMapper;

  @Override
  public Admin selectAdminByEmail(String email) {
    return entrityToModel(adminMapper.selectAdminByEmail(email));
  }


  /**
   * 数据库实例转为业务对象
   *
   * @param adminEntity admin数据库实例
   * @return admin业务对象
   */
  private Admin entrityToModel(AdminEntity adminEntity){
    Admin admin = null;
    if(adminEntity!=null){
      admin = new Admin();
      BeanUtils.copyProperties(adminEntity,admin);
    }
    return admin;
  }
}
