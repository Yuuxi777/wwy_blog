package com.example.wwy_blog.service.impl;

import com.example.wwy_blog.entity.Photo;
import com.example.wwy_blog.mapper.PhotoMapper;
import com.example.wwy_blog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoMapper photoMapper;

    /**
     * 获取所有照片
     *
     * @return 照片List
     */
    @Override
    public List<Photo> getAllPhotos() {
        List<Photo> photos = photoMapper.getAllPhotos();
        return photos;
    }

    /**
     * 根据id获取照片
     *
     * @param id :照片id
     * @return Photo类
     */
    @Override
    public Photo getPhotoById(Integer id) {
        Photo photo = photoMapper.getPhotoById(id);
        return photo;
    }

    /**
     * 根据id删除照片
     *
     * @param id :照片id
     * @return 1表示删除成功
     */
    @Override
    public Integer deletePhotoById(Integer id) {
        return photoMapper.deletePhotoById(id);
    }

    /**
     * 上传照片
     *
     * @param photo :照片类
     * @return 1表示上传成功
     */
    @Override
    public Integer uploadPhoto(Photo photo) {
       return photoMapper.uploadPhoto(photo);
    }
}
