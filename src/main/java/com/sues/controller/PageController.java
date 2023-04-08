package com.sues.controller;

import com.sues.entity.Category;
import com.sues.entity.Record;
import com.sues.mapper.RecordMapper;
import com.sues.mapper.UserMapper;
import com.sues.service.AuthService;
import com.sues.service.CategoryService;
import com.sues.service.RecordService;
import com.sues.service.impl.UserAuthService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private AuthService authService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private CategoryService categoryService;

    //给页面动态展示昵称
    public void showName(Model model){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String name = authService.getNameByUsername(authentication.getName());
        model.addAttribute("name", name);
    }

    //首页
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("expendNumber", recordService.getSumOfAmount());
        model.addAttribute("expendRecordNumber", recordService.getCountOfAmount());
        showName(model);
        return "index";
    }

    //登录
    @RequestMapping("/login")
    public String login(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("loginException", true);
        }
        return "login";
    }

    //注册
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    //记录以及记录列表展示
    @RequestMapping("/record")
    public String record(HttpServletRequest request, Model model) {
        showName(model);
        //定义记录列表，它可能是搜索出来的列表，也有可能是全部列表
        List<Record> recordList = (List<Record>) request.getAttribute("searchResults");
        //如果记录列表是空的，说明不是搜索出来的列表，则正常展示全部记录列表
        if (recordList == null) {
            recordList = recordService.getRecordList();
        }
        model.addAttribute("recordList", recordList);
        return "record";
    }

    //分类以及分类列表展示
    @RequestMapping("/category")
    public String category(HttpServletRequest request, Model model){
        showName(model);
        model.addAttribute("categoryList", categoryService.getCategoryList());
        List<Category> categoryList = (List<Category>) request.getAttribute("searchResults");
        if (categoryList == null) {
            categoryList = categoryService.getCategoryList();
        }
        model.addAttribute("categoryList", categoryList);
        return "category";
    }

    //账户设置页面
    @RequestMapping("/account")
    public String account(Model model){
        //获取昵称
        //showName(model);
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String name = authService.getNameByUsername(authentication.getName());
        model.addAttribute("name", name);

        //获取用户名
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "account";
    }

    @RequestMapping("/addRecord")
    public String addRecord(Model model){
        showName(model);
        model.addAttribute("getCategoryName", categoryService.getCategoryList());
        return "addRecord";
    }

    @RequestMapping("/updateRecord")
    public String updateRecord(Model model, @RequestParam("id")String id){
        showName(model);
        model.addAttribute("getCategoryName", categoryService.getCategoryList());
        model.addAttribute("preUpdateRecordList", recordService.getPreUpdateRecordList(id));
        model.addAttribute("id", id);
        return "updateRecord";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Model model){
        showName(model);
        return "addCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Model model, @RequestParam("id")String id){
        showName(model);
        model.addAttribute("preUpdateCategoryList", categoryService.getPreUpdateCategoryList(id));
        model.addAttribute("id", id);
        return "updateCategory";
    }
}
