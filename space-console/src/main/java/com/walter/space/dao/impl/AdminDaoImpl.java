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
    return entityToModel(adminMapper.selectAdminByEmail(email));
  }

  @Override
  public void add(Admin admin) {
    if(admin !=null){
      adminMapper.add(modelToEntity(admin));
    }
  }

  /**
   * 数据库实例转为业务对象
   *
   * @param adminEntity admin数据库实例
   * @return admin业务对象
   */
  private Admin entityToModel(AdminEntity adminEntity){
    Admin admin = null;
    if(adminEntity!=null){
      admin = new Admin();
      BeanUtils.copyProperties(adminEntity,admin);
    }
    return admin;
  }

  /**
   * 业务对象转为数据库实例
   *
   * @param admin admin业务对象
   * @return admin数据库实例
   */

  private AdminEntity modelToEntity(Admin admin){
    AdminEntity adminEntity = null;
    if(admin !=null){
      adminEntity = new AdminEntity();
      BeanUtils.copyProperties(admin,adminEntity);
    }
    return adminEntity;
  }
}
