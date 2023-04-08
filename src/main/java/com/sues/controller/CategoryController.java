package com.sues.controller;

import com.sues.entity.Category;
import com.sues.entity.Record;
import com.sues.service.CategoryService;
import com.sues.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam("id") String id){
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }

    @PostMapping("/addCategory")
    public String addCategory(String Name, String Type, String Status){
        categoryService.addCategory(Name,Type,Status);
        return "redirect:/category";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(String id, String Name, String Type, String Status){
        categoryService.updateCategory(id, Name, Type, Status);
        return "redirect:/category";
    }

    @GetMapping("/searchCategory")
    public String searchCategory(@RequestParam("search")String search, Model model){
        List<Category> searchResults = categoryService.getCategoryListBySearch(search);
        model.addAttribute("searchResults", searchResults);
        return "forward:/category";
    }
}
