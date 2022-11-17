package com.example.wwy_blog.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class PhotoUtil {

    public static final String UPLOAD_PATH = "/home/blog/photos/";

    public static final String[] requiredSuffix = {"PNG","JPG","JPEG","BMP","GIF","SVG"};

    public static String getSuffix (MultipartFile file){
        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
    }

    public static boolean judgeSuffix(String suffix) {
        return Arrays.asList(requiredSuffix).contains(suffix.toUpperCase());
    }

    public static String Operate(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString().replace("-","") + "." + PhotoUtil.getSuffix(file);

        File descFile = new File(UPLOAD_PATH,fileName);
        file.transferTo(descFile);

        String url = "/image/" + fileName;
        return url;
    }


}
