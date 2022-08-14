package com.example.wwy_blog.service.impl;

import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.entity.Category;
import com.example.wwy_blog.mapper.CategoryMapper;
import com.example.wwy_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories() {
        List<Category> result = categoryMapper.getAllCateGory();
        return result;
    }


    @Override
    public Category getCategoryById(Integer id) {
        Category result = categoryMapper.getCateGoryById(id);
        return result;
    }

    @Override
    public Category getCategoryByName(String name) {
        Category result = categoryMapper.getCategoryByName(name);
        return result;
    }

    @Override
    public Integer insertCategory(String name) {
        int result = categoryMapper.insertCategory(name);
        return result;
    }

    @Override
    public Integer deleteCategoryByName(String name) {
        int result = categoryMapper.deleteCategoryByName(name);
        return result;
    }
}
