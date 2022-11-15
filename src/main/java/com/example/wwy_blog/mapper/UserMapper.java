package com.example.wwy_blog.mapper;

import com.example.wwy_blog.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @ResultType(User.class)
    @Select("SELECT * FROM user WHERE account = #{account} AND password = #{password}")
    User getUserByAccountAndPassword(@Param("account") String account,
                                     @Param("password")String password);

    @Insert("INSERT INTO user(account,password) VALUES(#{user.account},#{user.password})")
    int InsertUser(User user);
}
