package com.example.wwy_blog.mapper;

import com.example.wwy_blog.entity.Photo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PhotoMapper {

    @ResultType(Photo.class)
    @Select("SELECT * FROM photo")
    List<Photo> getAllPhotos();

    @Select("SELECT * FROM photo WHERE id = #{id}" )
    Photo getPhotoById(@Param("id")Integer id);

    @Delete("DELETE FROM photo WHERE id = #{id}")
    int deletePhotoById(@Param("id") Integer id);

    @Insert("INSERT INTO photo(url) VALUES (#{photo.url})")
    int uploadPhoto(@Param("photo")Photo photo);
}
