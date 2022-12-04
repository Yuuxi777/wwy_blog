package com.example.wwy_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "likes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "blog_id")
    private Integer blogId;

    @Column(name = "like_ip")
    private String likeIp;
}
