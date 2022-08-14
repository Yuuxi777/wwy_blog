package com.example.wwy_blog.controller;

import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.entity.User;
import com.example.wwy_blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    Result r = new Result();

    @PostMapping ("/login")
    public Result login(HttpSession session, @RequestBody User user){
        String password = user.getPassword();
        String account = user.getAccount();
        if (userMapper.getUserByAccountAndPassword(account,password) != null)
        {
            session.setAttribute("user",user);
            return r.success("登录成功");
        }
        return r.fail("用户名或密码错误");


    }

}
