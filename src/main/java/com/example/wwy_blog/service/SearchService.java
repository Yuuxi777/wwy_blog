package com.example.wwy_blog.service;

import com.example.wwy_blog.entity.Blog;

import java.util.List;

public interface SearchService {
    List<Blog> getSearchResult(String keyword);
}
