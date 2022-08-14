package com.example.wwy_blog.service;

import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();

    public Category getCategoryById(Integer id);

    public Category getCategoryByName(String name);

    public Integer insertCategory(String name);

    public Integer deleteCategoryByName(String name);

}
