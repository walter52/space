package com.walter.space.console.dao.provider;

import org.apache.ibatis.annotations.Param;

/**
 * @author walter
 * @date 2020/2/23 7:23 下午
 */
public class AdminSqlProvider {

    public String selectByEmail(@Param("email") String email){
        return "SELECT * FROM space_console_admin WHERE email=#{email};";
    }
}
