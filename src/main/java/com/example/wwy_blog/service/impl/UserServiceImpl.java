package com.example.wwy_blog.service.impl;

import com.example.wwy_blog.entity.User;
import com.example.wwy_blog.mapper.UserMapper;
import com.example.wwy_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 根据账号密码获取user
     *
     * @param account :账号
     * @param password :密码
     * @return user类
     */
    @Override
    public User getUser(String account, String password) {
        try {
            return  userMapper.getUserByAccountAndPassword(account,password);
        }catch (NullPointerException e) {
            return null;
        }
    }
}
