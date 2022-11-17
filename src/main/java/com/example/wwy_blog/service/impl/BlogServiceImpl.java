package com.example.wwy_blog.service.impl;

import com.example.wwy_blog.entity.Blog;
import com.example.wwy_blog.entity.Category;
import com.example.wwy_blog.mapper.BlogMapper;
import com.example.wwy_blog.mapper.CategoryMapper;
import com.example.wwy_blog.service.BlogService;
import com.example.wwy_blog.utils.Html2PlainText;
import com.example.wwy_blog.utils.Markdown2Html;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Blog getBlogById(int id) {
        Blog result = blogMapper.getBlogById(id);
        result.timeSwitch();
        return result;
    }

    @Override
    public Integer UploadBlog(Blog blog) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        blog.setCreateTime(time);
        int result = blogMapper.uploadBlog(blog);
        String category = blog.getCategory();
        if (categoryMapper.getCategoryByName(category) == null){
            categoryMapper.insertCategory(blog.getCategory());
        }
        return result;
    }

    @Override
    public Integer DeleteBlogById(Integer id) {
        int result = 0;
        Blog deleteBlog = blogMapper.getBlogById(id);
        if(deleteBlog != null){
           result = blogMapper.deleteBlogById(id);
        }
        return result;
    }

    @Override
    public List<Blog> getAllBlogs() {
        List<Blog> result = blogMapper.getAllBlogs();
        return convertBlogs(result);
    }

    public List<Blog> convertBlogs(List<Blog> result) {
        for(Blog blog:result){
            blog.timeSwitch();

            String htmlTitle = Markdown2Html.convert(blog.getTitle());
            blog.setTitle(Html2PlainText.convert(htmlTitle));

            String htmlContent = Markdown2Html.convert(blog.getContent());
            blog.setContent(Html2PlainText.convert(htmlContent));
        }
        return result;
    }

    @Override
    public List<Blog> getBlogByCategory(String name) {
        Category category1 = categoryMapper.getCategoryByName(name);
        if (category1 != null){
            List<Blog> result = blogMapper.getBlogByCategory(name);
            return convertBlogs(result);
        }
        return null;
    }

    @Override
    public List<Blog> getRecentBlog(int num) {
        List<Blog> result = blogMapper.getRecentBlogs(num);
        return convertBlogs(result);
    }

    @Override
    public Integer getBlogCount() {
        return blogMapper.getBlogCount();
    }

    public List<Blog> getBlogByAllCategory(List<Category> categories){
        categories = categoryMapper.getAllCateGory();
        for(Category category:categories){
            if(categoryMapper.getCategoryByName(category.getName())!=null){
               return blogMapper.getBlogByCategory(category.getName());
            }
        }
        return null;
    }
}
