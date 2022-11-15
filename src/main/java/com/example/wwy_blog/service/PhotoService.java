package com.example.wwy_blog.service;

import com.example.wwy_blog.entity.Photo;
import java.util.List;

public interface PhotoService {

    public List<Photo> getAllPhotos();

    public Photo getPhotoById(Integer id);

    public Integer deletePhotoById(Integer id);

    public Integer uploadPhoto(Photo photo);
}
