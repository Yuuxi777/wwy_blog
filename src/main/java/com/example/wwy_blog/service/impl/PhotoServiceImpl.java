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

    @Override
    public List<Photo> getAllPhotos() {
        List<Photo> photos = photoMapper.getAllPhotos();
        return photos;
    }

    @Override
    public Photo getPhotoById(Integer id) {
        Photo photo = photoMapper.getPhotoById(id);
        return photo;
    }

    @Override
    public Integer deletePhotoById(Integer id) {
        return photoMapper.deletePhotoById(id);
    }

    @Override
    public Integer uploadPhoto(Photo photo) {
       return photoMapper.uploadPhoto(photo);
    }
}
