package com.sues.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.security.PrivateKey;

public interface AuthService {

    boolean register(String name, String username, String password);

    String getNameByUsername(String username);

    //修改密码
    boolean updatePassword(String oldPassword, String newPassword,String username);

    //检查密码
    boolean checkPassword(String currentPassword, String username);

    //获取密码
    String getPasswordByUsername(String username);

    //修改昵称
    boolean updateName(String name, String username);
}
