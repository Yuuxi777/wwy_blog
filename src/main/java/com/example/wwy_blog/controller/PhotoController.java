package com.example.wwy_blog.controller;


import com.example.wwy_blog.common.Result;
import com.example.wwy_blog.entity.Photo;
import com.example.wwy_blog.service.impl.PhotoServiceImpl;
import com.example.wwy_blog.utils.PhotoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class PhotoController {

    @Autowired
    PhotoServiceImpl photoService;

    private String requiredSuffix[] = {"PNG","JPG","JPEG","BMP","GIF","SVG"};

    @PostMapping("/uploadPhoto")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return Result.fail("文件不能为空！");
        }
        if (!PhotoUtil.judgeSuffix(PhotoUtil.getSuffix(file))){
            return Result.fail("请选择正确格式的照片！");
        }
        String url = PhotoUtil.Operate(file);
        return Result.success("上传成功",url);
    }

    @PostMapping("/uploadPhotos")
    public Result uploads(@RequestParam("files") MultipartFile files[]) throws IOException {

        List<String> urls = new ArrayList<>();
        if (files.length == 0){
            return Result.fail("文件不能为空！");
        }
        for (MultipartFile file: files) {

            if (!PhotoUtil.judgeSuffix(PhotoUtil.getSuffix(file))){
                return Result.fail("请选择正确格式的照片！");
            }
            String url = PhotoUtil.Operate(file);
            photoService.uploadPhoto(new Photo(url));
            urls.add(url);
        }
        return Result.success("上传成功！",urls);
    }

    @GetMapping("/getAllPhotos")
    public Result getAllPhotos(){
        List<Photo> photoList = photoService.getAllPhotos();
        return Result.success("查询成功！",photoList);
    }
}
