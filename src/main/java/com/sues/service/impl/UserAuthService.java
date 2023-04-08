package com.sues.service.impl;

import com.sues.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    private UserMapper mapper;

    //登录功能
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String password = mapper.getPasswordByUsername(s); //从数据库根据用户名获取密码
        if(password == null)
            throw new UsernameNotFoundException("登录失败，用户名或密码错误！");
        return User //返回UserDetails，SpringSecurity会根据给定的信息进行比对
                .withUsername(s)
                .password(password) //从数据库获取密码
                .roles("user") //用户角色
                .build();
    }
}
