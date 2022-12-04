package com.example.wwy_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WwyBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwyBlogApplication.class, args);
    }

}
