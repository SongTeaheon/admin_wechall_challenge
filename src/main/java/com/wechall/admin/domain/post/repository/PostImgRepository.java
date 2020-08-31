package com.wechall.admin.domain.post.repository;

import com.wechall.admin.domain.post.model.entity.PostImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImgRepository extends JpaRepository<PostImg, Long> {
    
}