package com.wechall.admin.domain.post.repository;

import com.wechall.admin.domain.post.model.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}