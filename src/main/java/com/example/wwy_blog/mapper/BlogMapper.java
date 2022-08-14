package com.example.wwy_blog.mapper;

import com.example.wwy_blog.entity.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {


    @ResultType(Blog.class)
    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog getBlogById(@Param("id") Integer id);

    @ResultType(Blog.class)
    @Select("SELECT * FROM blog")
    List<Blog> getAllBlogs();

    @ResultType(Blog.class)
    @Select("SELECT * FROM blog ORDER BY create_time DESC LIMIT 0 , #{num}" )
    List<Blog> getRecentBlogs(@Param("num") Integer num);

    @ResultType(Blog.class)
    @Select("SELECT * FROM blog WHERE category = #{name}")
    List<Blog> getBlogByCategory(@Param("name") String name);

    @Insert("INSERT INTO blog(category,content,create_time,title) " +
            "VALUES(#{blog.category}, #{blog.content}, #{blog.createTime}, #{blog.title})")
    int uploadBlog(@Param("blog") Blog blog);

    @Update("UPDATE blog set")
    int updateBlogById(Integer id);

    @Delete("DELETE FROM blog WHERE id = #{id}")
    int deleteBlogById(@Param("id") Integer id);

    @ResultType(Integer.class)
    @Select("SELECT COUNT(*) FROM blog")
    int getBlogCount();

}
