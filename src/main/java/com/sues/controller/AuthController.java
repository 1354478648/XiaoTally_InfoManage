package com.sues.controller;

import com.sues.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    //注册功能
    @PostMapping
    @RequestMapping("/doRegister")
    public String register(@RequestParam("name") String name,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password){
        authService.register(name, username, password);
        return "login";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(Model model,
                                 @RequestParam("originPassword") String currentPassword,
                                 @RequestParam("newFirstPassword") String newPassword,
                                 @RequestParam("newSecondPassword") String confirmPassword,
                                 Authentication authentication){

        //前端已完成“两次新密码匹配”和“旧密码新密码匹配”的情况
        //获取当前用户的用户名
        String username = authentication.getName();

        //验证当前密码是否正确
        if (!authService.checkPassword(currentPassword, username)) {
            model.addAttribute("currentPasswordError", true);
            return "account";
        }

        //验证新密码和确认密码是否匹配
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("newPasswordError", true);
            return "account";
        }

        //更新密码并检查结果
        if (!authService.updatePassword(currentPassword, newPassword, username)) {
            model.addAttribute("updatePasswordError", true);
            return "account";
        }

        return "redirect:/account";
    }

    @PostMapping("/updateName")
    public String updateName(@RequestParam("nickname") String name,
                             @RequestParam("username") String username){
        authService.updateName(name, username);
        return "redirect:/account";

    }
}
