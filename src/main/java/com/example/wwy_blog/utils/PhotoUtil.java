package com.example.wwy_blog.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@Component
public class PhotoUtil {

    public static final String UPLOAD_PATH_LINUX = "/home/blog/photos/";
    public static final String UPLOAD_PATH_WIN = "E:/phototest/";
    public static final Integer REQUIRED_SIZE = 1024 * 1024;

    public static final String[] requiredSuffix = {"PNG","JPG","JPEG","BMP","GIF","SVG"};

    /**
     * 获取上传文件的后缀
     *
     * @param file :上传的文件
     * @return 后缀名
     */
    public static String getSuffix (MultipartFile file){
        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
    }

    /**
     * 判断后缀名是否为要求格式
     *
     * @param suffix :文件后缀名
     * @return true表示符合要求 false表示不符要求
     */
    public static boolean judgeSuffix(String suffix) {
        return Arrays.asList(requiredSuffix).contains(suffix.toUpperCase());
    }

    /**
     * 上传图片，对过大的图片进行压缩
     *
     * @param file :上传的图片
     * @return url :图片映射后的虚拟url
     */
    public static String Operate(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String suffix = PhotoUtil.getSuffix(file);
        String fileName = UUID.randomUUID().toString().replace("-","") + "." + suffix;

        if (file.getSize() > REQUIRED_SIZE) {
            System.out.println("1");
            Thumbnails.of(file.getInputStream()).scale(1.0f)
                    .outputQuality(0.1f)
                    .toFile(UPLOAD_PATH_LINUX+fileName);
        } else {
            File descFile = new File(UPLOAD_PATH_LINUX,fileName);
            file.transferTo(descFile);
        }

        String url = "/image/" + fileName;
        return url;
    }




}
