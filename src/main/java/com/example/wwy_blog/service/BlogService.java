package com.example.wwy_blog.service;

import com.example.wwy_blog.entity.Blog;


import java.util.List;

public interface BlogService {

    public List<Blog> getRecentBlog(int num);

    public Blog getBlogById(int id);

    public List<Blog> getBlogByCategory(String name);

    public Integer UploadBlog(Blog blog);

    public Integer DeleteBlogById(Integer id);

    public List<Blog> getAllBlogs();

    public Integer getBlogCount();
}
