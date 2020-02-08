package com.walter.space.console.dao.mapper;

import com.walter.space.console.dao.entity.AdminEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author walterwu
 * @date 2018/04/03
 */
@Mapper
public interface AdminMapper {

  /**
   * 根据email获取用户
   *
   * @param email email
   * @return admin数据库实例
   */
  @Select("SELECT * FROM space_console_admin WHERE email=#{email};")
  AdminEntity selectAdminByEmail(@Param("email") String email);

  /**
   * 添加新的管理员
   */
  @Insert(
      "INSERT INTO space_console_admin(email,password,name,role_code,status,created_by,created_on,last_changed_by,last_changed_on) "
          + "VALUES(#{email},#{password}),#{name},#{roleCode},#{status},#{createdBy},#{createdOn},#{lastChangedBy},#{lastChangedOn}")
  int add(AdminEntity adminEntity);
}
