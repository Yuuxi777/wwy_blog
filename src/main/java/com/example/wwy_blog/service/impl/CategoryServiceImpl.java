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

    /**
     * 获取所有分类
     *
     * @return 分类列表
     */
    @Override
    public List<Category> getAllCategories() {
        List<Category> result = categoryMapper.getAllCateGory();
        return result;
    }

    /**
     * 根据id获取分类
     *
     * @param id :分类id
     * @return Category类
     */
    @Override
    public Category getCategoryById(Integer id) {
        Category result = categoryMapper.getCateGoryById(id);
        return result;
    }

    /**
     * 根据name获取分类
     *
     * @param name :分类名
     * @return Category类
     */
    @Override
    public Category getCategoryByName(String name) {
        Category result = categoryMapper.getCategoryByName(name);
        return result;
    }

    /**
     * 新建一个分类
     *
     * @param name :分类名
     * @return 1表示新建成功
     */
    @Override
    public Integer insertCategory(String name) {
        int result = categoryMapper.insertCategory(name);
        return result;
    }

    /**
     * 删除一个分类
     *
     * @param name :分类名
     * @return 1表示删除成功
     */
    @Override
    public Integer deleteCategoryByName(String name) {
        int result = categoryMapper.deleteCategoryByName(name);
        return result;
    }
}
