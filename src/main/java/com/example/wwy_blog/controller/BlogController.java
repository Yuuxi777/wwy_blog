package com.example.wwy_blog.controller;

import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.entity.Blog;
import com.example.wwy_blog.service.impl.BlogServiceImpl;
import com.example.wwy_blog.service.impl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    CategoryServiceImpl categoryService;

    Result r = new Result();

    @GetMapping("/getAllBlogs")
    public Result getAllBlogs(){
        return r.success("查询成功",blogService.getAllBlogs());
    }

    @GetMapping("/getRecentBlog")
    public Result getRecentBlog(@RequestParam(value = "num")Integer id){
        return r.success("查询成功",blogService.getRecentBlog(id));
    }

    @GetMapping("/getBlogById")
    public Result getBlogById(@RequestParam(value = "id")Integer id){
        Blog result = blogService.getBlogById(id);
        if (result == null){
            return r.fail("博客不存在,请检查id");
        }
        return r.success("查询成功,id为"+result.getId(),result);
    }

    @PostMapping("/uploadBlog")
    public Result uploadBlog(@RequestBody Blog blog) {
        int result =  blogService.UploadBlog(blog);
        if(result == 1){
            return r.success("上传成功");
        }
        return r.fail("上传失败");
    }

    @PostMapping("/deleteBlog")
    public Result deleteBlog(@RequestParam(value = "id") Integer id) {
        int result = blogService.DeleteBlogById(id);
        if (result ==0){
            return r.fail("删除失败,请检查id");
        }
        else {
            String category = blogService.getBlogById(id).getCategory();
            if(blogService.getBlogByCategory(category) == null)
            {
                categoryService.deleteCategoryByName(category);
            }
            return r.success("删除成功,删除的论文id为"+id);
        }

    }

    @GetMapping("/getBlogByCategory")
    public Result getBlogByCategory(@RequestParam(value = "name") String name){
        List<Blog> result = blogService.getBlogByCategory(name);
        if (result == null)
            return r.fail("查询为空,请检查分类名");
        return r.success("查询成功",result);
    }

    @GetMapping("/getBlogCount")
    public Result getBlogCount(){
        return r.success("查询成功",blogService.getBlogCount());
    }

}