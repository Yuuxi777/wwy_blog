package com.example.wwy_blog.mapper;

import com.example.wwy_blog.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category")
    List<Category> getAllCateGory();

    @Select("SELECT * FROM category where id = #{id} ")
    Category getCateGoryById(@Param("id") Integer id);

    @Select("SELECT * FROM category where name = #{name}")
    Category getCategoryByName(@Param("name") String name);

    @Insert("INSERT INTO category(name,is_fold) VALUES (#{name},true)")
    Integer insertCategory(@Param("name") String name);

    @Delete("DELETE FROM category WHERE name = #{name}")
    Integer deleteCategoryByName(@Param("id") String id);
}
