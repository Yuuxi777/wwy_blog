package com.example.wwy_blog.controller;

import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    Result r = new Result();

    @GetMapping("/getAllCategories")
    public Result getAllCategories(){
        return r.success("查询成功",categoryService.getAllCategories());
    }

    @PostMapping("/insertCategory")
    public Result insertCategory(@RequestParam(value = "name") String name){
       int result =  categoryService.insertCategory(name);
       if(result == 1){
           return r.success("插入成功");
       }
        return r.fail("插入失败");
    }

}
