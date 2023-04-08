package com.sues.mapper;

import com.sues.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //获取密码
    @Select("select Password from user where Username = #{username}")
    String getPasswordByUsername(String username);

    @Select("select Name from user where Username = #{username}")
    String getNameByUsername(String username);

    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into user(name, username, password) values (#{name}, #{username}, #{password})")
    int registerUser(User user);

    //修改密码
    @Update("update user set password = #{password} where username = #{username}")
    boolean updatePassword(@Param("password")String password,@Param("username")String username);

    //修改昵称
    @Update("update user set name = #{name} where username = #{username}")
    void updateName(@Param("name")String name,@Param("username")String username);
}
