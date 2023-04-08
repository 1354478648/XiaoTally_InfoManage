package com.sues.service.impl;

import com.sues.entity.Category;
import com.sues.mapper.CategoryMapper;
import com.sues.mapper.RecordMapper;
import com.sues.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    @Override
    public void addCategory(String Name, String Type, String Status) {
        categoryMapper.addCategory(Name, Type, Status);
    }

    @Override
    public void deleteCategory(String id) {
        categoryMapper.deleteCategory(id);
    }

    @Override
    public void updateCategory(String id, String Name, String Type, String Status) {
        categoryMapper.updateCategory(id, Name, Type, Status);
    }

    @Override
    public List<Category> getCategoryListBySearch(String search) {
        return categoryMapper.getCategoryListBySearch(search);
    }

    @Override
    public List<Category> getPreUpdateCategoryList(String id) {
        return categoryMapper.getPreUpdateCategoryList(id);
    }
}
