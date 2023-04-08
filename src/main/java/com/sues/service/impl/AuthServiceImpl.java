package com.sues.service.impl;

import com.sues.entity.User;
import com.sues.mapper.UserMapper;
import com.sues.service.AuthService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(String name, String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User(null, name , username, encoder.encode(password));
        if(userMapper.registerUser(user) <= 0)
            throw new RuntimeException("用户基本信息添加失败");
        return true;
    }

    @Override
    public String getNameByUsername(String username) {
        return userMapper.getNameByUsername(username);
    }

    @Override
    public boolean updatePassword(String oldPassword, String newPassword, String username) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //获取用户的旧密码
        String dbPassword = userMapper.getPasswordByUsername(username);

        //验证旧密码是否正确
        if (!passwordEncoder.matches(oldPassword, dbPassword)) {
            return false;
        }

        //更新密码
        userMapper.updatePassword(passwordEncoder.encode(newPassword), username);
        return true;
    }

    @Override
    public boolean checkPassword(String currentPassword, String username) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //获取用户的旧密码
        String dbPassword = userMapper.getPasswordByUsername(username);

        //验证密码是否正确
        return passwordEncoder.matches(currentPassword, dbPassword);
    }

    @Override
    public String getPasswordByUsername(String username) {
        return userMapper.getPasswordByUsername(username);
    }

    @Override
    public boolean updateName(String name, String username) {
        userMapper.updateName(name, username);
        return true;
    }
}
