package com.walter.space.dao.mapper;

import com.walter.space.dao.entity.AdminEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author walterwu
 * @date 2018/04/03
 */
public interface AdminMapper {
    /**
     * 根据email获取用户
     *
     * @param email
     * @return
     */
    @Select("SELECT * FROM space_console_admin WHERE email=#{email};")
    AdminEntity selectAdminByEmail(@Param("email") String email);
}
