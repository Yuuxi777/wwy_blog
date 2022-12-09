package com.example.wwy_blog.utils;

import com.example.wwy_blog.entity.Likes;
import com.example.wwy_blog.mapper.BlogMapper;
import com.example.wwy_blog.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ScheduleTasksUtil {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    LikeMapper likeMapper;

    private static String LIKE_KEY(Integer id) {
        return "blog_" + id.toString() + ":likes";
    }

    @Scheduled(fixedRate = 5000)
    public void persistToSQL() {
        int cnt = blogMapper.getBlogCount();
        try {
            for (int i = 1; i <= cnt ; i++) {
                Set<Object> likesSet = redisUtil.sGet(LIKE_KEY(i));
                if (likesSet.size() == 0) {
                    continue;
                }
                for (Object ip: likesSet) {
                    if (!ip.toString().equals("") && likeMapper.getLikeByIdAndIp(i,ip.toString()) == null) {
                        likeMapper.insert(i, ip.toString());
                        System.out.println("新增一条数据");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
