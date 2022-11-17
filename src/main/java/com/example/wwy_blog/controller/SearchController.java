package com.example.wwy_blog.controller;

import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.entity.Blog;
import com.example.wwy_blog.service.impl.SearchServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    SearchServiceImpl searchService;

    @GetMapping("/search")
    public Result SearchBlog(@RequestParam String keyword) {
      List<Blog> blogs = searchService.getSearchResult(keyword);
      if (blogs.size() == 0) {
          return Result.success("结果为空",null);
      }
      return Result.success("搜索成功",blogs);
    }
}
