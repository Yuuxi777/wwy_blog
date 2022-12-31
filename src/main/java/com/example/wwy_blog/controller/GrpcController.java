package com.example.wwy_blog.controller;

import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.entity.Blog;
import com.example.wwy_blog.grpc.blog.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class GrpcController {
    @GrpcClient("grpc-server")
    private BlogServiceGrpc.BlogServiceBlockingStub blogStub;

    @GetMapping("/gRPCGetBlogById")
    public Result gRpcGetBlog(@RequestParam int id) {
        // 设置入参request
        BlogRequest request = BlogRequest.newBuilder().setId(id).build();
        // 根据入参获取response
        BlogResponse response = blogStub.getBlogById(request);
        // 返回
        if (response.getId() != 0) {
            Blog blog = new Blog(response.getId(),response.getTitle(),response.getContext(),response.getCategory(),response.getCreateTime(),0L);
            return Result.success("查询成功,id为"+blog.getId(),blog);
        }
        return Result.fail("博客不存在,请检查id");
    }

    @GetMapping("/gRPCGetAllBlogs")
    public Result gRPCGetAllBlogs() {
        List<Blog> blogs = new ArrayList<>();

        BlogsRequest request = BlogsRequest.newBuilder().build();

        BlogsResponse response = blogStub.getAllBlogs(request);

        if (response.getBlogsCount() != 0) {
            List<BlogResponse> responses = response.getBlogsList();
            for (BlogResponse res: responses) {
                Blog blog = new Blog(res.getId(),res.getTitle(),res.getContext(),res.getCategory(),res.getCreateTime(),0L);
                assert false;
                blogs.add(blog);
            }
            return Result.success("查询成功",blogs);
        }
        return Result.fail("查询失败");
    }
}
