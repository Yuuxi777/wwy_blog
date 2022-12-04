package com.example.wwy_blog.mapper;

import com.example.wwy_blog.entity.Likes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LikeMapper {

    @Insert("INSERT INTO likes(blog_id,like_ip) VALUES(#{id}, #{ip})")
    void insert(@Param(value = "id") Integer blogId,
                       @Param(value = "ip") String ip);

    @Delete("DELETE FROM likes WHERE 1=1 AND blog_id=id AND like_ip=ip")
    void delete(@Param(value = "id") Integer blogId,
                       @Param(value = "ip") String ip);

    @ResultType(Likes.class)
    @Select("SELECT * FROM likes WHERE 1=1 AND blog_id=#{id}")
    List<Likes> getLikeSetById(@Param(value = "id") Integer blogId);

    @ResultType(Likes.class)
    @Select("SELECT * FROM likes WHERE 1=1 AND blog_id=#{id} AND like_ip=#{ip}")
    Likes getLikeByIdAndIp(@Param(value = "id") Integer blogId,
                           @Param(value = "ip") String ip);

}
