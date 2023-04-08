package com.sues.service;

import com.sues.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategoryList();

    void addCategory(String Name,String Type,String Status);

    void deleteCategory(String id);

    void updateCategory(String id, String Name, String Type, String Status);

    List<Category> getCategoryListBySearch(String search);

    List<Category> getPreUpdateCategoryList(String id);
}
