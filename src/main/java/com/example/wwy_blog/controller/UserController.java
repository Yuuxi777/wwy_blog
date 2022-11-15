package com.example.wwy_blog.controller;

import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.entity.User;
import com.example.wwy_blog.service.impl.UserServiceImpl;
import com.example.wwy_blog.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping ("/login")
    public Result login(@RequestBody User user){
        String account = user.getAccount();
        String password = user.getPassword();
        if (userService.getUser(account,password) == null) {
            return Result.fail("用户名或密码错误");
        }else {
            String token = TokenUtil.sign(account);
            return Result.success("登录成功",token);
        }
    }

}
