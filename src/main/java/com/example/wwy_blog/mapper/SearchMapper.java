package com.example.wwy_blog.mapper;

import com.example.wwy_blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchMapper {

    @Select("SELECT id,category,content,create_time,title FROM blog " +
            "WHERE 1 = 1 AND " +
            "content like concat('%', #{keyword}, '%') OR " +
            "category like concat('%', #{keyword}, '%') OR " +
            "title like concat('%', #{keyword}, '%')")
    List<Blog> getSearchResult(@Param("keyword")String keyword);
}
