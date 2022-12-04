package com.example.wwy_blog.service.impl;

import com.example.wwy_blog.entity.Blog;
import com.example.wwy_blog.mapper.SearchMapper;
import com.example.wwy_blog.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchMapper searchMapper;

    @Autowired
    BlogServiceImpl blogService;

    /**
     * 根据关键词获取博客列表
     *
     * @param keyword :搜索的关键词
     * @return 博客list
     */
    @Override
    public List<Blog> getSearchResult(String keyword) {
        List<Blog> result = searchMapper.getSearchResult(keyword);
        return blogService.convertBlogs(result);
    }
}
