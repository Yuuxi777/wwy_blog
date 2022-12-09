package com.example.wwy_blog.service.impl;

import com.example.wwy_blog.entity.Blog;
import com.example.wwy_blog.entity.Category;
import com.example.wwy_blog.entity.Likes;
import com.example.wwy_blog.mapper.BlogMapper;
import com.example.wwy_blog.mapper.CategoryMapper;
import com.example.wwy_blog.mapper.LikeMapper;
import com.example.wwy_blog.service.BlogService;
import com.example.wwy_blog.utils.Html2PlainText;
import com.example.wwy_blog.utils.IpUtil;
import com.example.wwy_blog.utils.Markdown2Html;
import com.example.wwy_blog.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisUtil redisUtil;

    private static String LIKE_KEY(Integer id) {
        return "blog_" + id.toString() + ":likes";
    }

    /**
     * 根据id获取博客
     *
     * @param  id :博客id
     * @return 博客类
     */
    @Override
    public Blog getBlogById(int id) {
        Blog result = blogMapper.getBlogById(id);
        result.timeSwitch();
        return result;
    }

    /**
     * 返回所有博客
     *
     * @return 所有博客的列表
     */
    @Override
    public List<Blog> getAllBlogs() {
        List<Blog> result = blogMapper.getAllBlogs();
        return convertBlogs(result);
    }

    /**
     * 返回按时间倒序排列的最近num篇博客
     *
     * @param  num :指定返回的博客数量
     * @return 博客列表
     */
    @Override
    public List<Blog> getRecentBlog(int num) {
        List<Blog> result = blogMapper.getRecentBlogs(num);
        for (Blog blog: result) {
            blog.setLikes(getLikes(blog.getId()));
        }
        return convertBlogs(result);
    }

    /**
     * 上传博客
     *
     * @param blog: 博客类
     */
    @Override
    public Integer UploadBlog(Blog blog) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        blog.setCreateTime(time);
        int result = blogMapper.uploadBlog(blog);
        String category = blog.getCategory();
        if (categoryMapper.getCategoryByName(category) == null) {
            categoryMapper.insertCategory(blog.getCategory());
        }
        return result;
    }

    /**
     * 按id删除博客
     *
     * @param  id :博客id
     * @return 1表示删除成功
     */
    @Override
    public Integer DeleteBlogById(Integer id) {
        int result = 0;
        Blog deleteBlog = blogMapper.getBlogById(id);
        if (deleteBlog != null) {
           result = blogMapper.deleteBlogById(id);
        }
        return result;
    }

    /**
     * 将博客从md格式转成文本格式并转化时间戳
     *
     * @param result :传入的博客列表
     * @return 转换后的博客列表
     */
    public List<Blog> convertBlogs(List<Blog> result) {
        for (Blog blog:result) {
            blog.timeSwitch();

            String htmlTitle = Markdown2Html.convert(blog.getTitle());
            blog.setTitle(Html2PlainText.convert(htmlTitle));

            String htmlContent = Markdown2Html.convert(blog.getContent());
            blog.setContent(Html2PlainText.convert(htmlContent));
        }
        return result;
    }

    /**
     * 返回指定分类的所有博客
     *
     * @param  name :分类名
     * @return 博客列表
     */
    @Override
    public List<Blog> getBlogByCategory(String name) {
        Category category1 = categoryMapper.getCategoryByName(name);
        if (category1 != null) {
            List<Blog> result = blogMapper.getBlogByCategory(name);
            return convertBlogs(result);
        }
        return null;
    }

    /**
     * 获取博客数量
     *
     * @return 博客数
     */
    @Override
    public Integer getBlogCount() {
        return blogMapper.getBlogCount();
    }

    /**
     * 要注意的是点赞时不需要写回mysql
     * 如果该ip已经点过赞就直接返回
     * 没有点过赞则在redis中维护
     *
     * @param id :博客id
     * @param request :用于获取客户端ip
     */
    @Override
    public void setLikes(Integer id, HttpServletRequest request) {
        String ip = IpUtil.getIpAddress(request);
        Long likes = getLikesFromRedis(id);
        if (likes == null) {
            List<Likes> likeList = likeMapper.getLikeSetById(id);
            for (Likes like:likeList) {
                redisUtil.sSet(LIKE_KEY(id), like.getLikeIp());
            }
        }
        redisUtil.sSet(LIKE_KEY(id), ip);
    }

    /**
     * 从redis中查询是否点赞
     *
     * @param  id :博客id
     * @param  ip :发出请求的客户端ip
     * @return true表示当前ip点过赞 false表示没有点过赞
     */
    @Override
    public boolean isLikeFromRedis(Integer id, String ip) {
        boolean isLike;
        try {
            isLike = redisUtil.sHasKey(LIKE_KEY(id), ip);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return isLike;
    }

    /**
     * 从SQL中查询是否点赞
     *
     * @param  id :博客id
     * @param  ip :发出请求的客户端ip
     * @return true表示当前ip点过赞 false表示没有点过赞
     */
    @Override
    public boolean isLikeFromSQL(Integer id, String ip) {
        try {
            likeMapper.getLikeByIdAndIp(id, ip);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 如果redis中有维护就取出，否则从mysql中取出并存到redis
     * 如果mysql中也没有则初始化mysql和redis
     *
     * @param  id :博客id
     * @return likes:从redis或mysql中取出的点赞数
     */
    @Override
    public Long getLikes(Integer id) {

        // 判断redis中是否维护点赞数,有则直接返回
        Long likes = getLikesFromRedis(id);
        if (likes != null) return likes;

        // 没有维护则从mysql中取出并写回redis
        // mysql中也没有维护就初始化为0同时初始化redis
        likes = Optional.ofNullable(blogMapper.getLikesById(id)).orElse(0L);
        List<Likes> likeList = likeMapper.getLikeSetById(id);
        if (likeList.size() == 0) {
            redisUtil.sSet(LIKE_KEY(id), "");
        } else {
            for (Likes like:likeList) {
                redisUtil.sSet(LIKE_KEY(id), like.getLikeIp());
            }
        }

        // 返回点赞数
        return likes;
    }

    /**
     * 从redis中取出点赞数
     *
     * @param  id :博客id
     * @return likes :redis中维护的点赞数
     */
    @Override
    public Long getLikesFromRedis(Integer id) {
        long likes = 0;
        try {
            Set<Object> likeSet = redisUtil.sGet(LIKE_KEY(id));
            if (likeSet.size() == 0) {
                return null;
            }
            for (Object ip : likeSet) {
                if (!ip.toString().equals("")) {
                    likes++;
                }
            }
        } catch (Exception e) {
            System.out.println("likeSet null");
            e.printStackTrace();
            return null;
        }
        return likes;
    }

    public List<Blog> getBlogByAllCategory(List<Category> categories) {
        categories = categoryMapper.getAllCateGory();
        for (Category category:categories) {
            if (categoryMapper.getCategoryByName(category.getName()) != null) {
                return blogMapper.getBlogByCategory(category.getName());
            }
        }
        return null;
    }
}
