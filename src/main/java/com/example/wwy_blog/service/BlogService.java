package com.example.wwy_blog.service;

import com.example.wwy_blog.entity.Blog;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BlogService {

    List<Blog> getRecentBlog(int num);

    Blog getBlogById(int id);

    List<Blog> getBlogByCategory(String name);

    Integer UploadBlog(Blog blog);

    Integer DeleteBlogById(Integer id);

    List<Blog> getAllBlogs();

    Integer getBlogCount();

    Long getLikesFromRedis(Integer id);

    Long getLikes(Integer id);

    void setLikes(Integer id, HttpServletRequest request);

    boolean isLikeFromRedis(Integer id, String ip);

    boolean isLikeFromSQL(Integer id,String ip);
}
