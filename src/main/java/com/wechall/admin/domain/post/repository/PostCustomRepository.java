package com.wechall.admin.domain.post.repository;

import com.wechall.admin.domain.post.model.entity.Post;

public interface PostCustomRepository {
    Post findByIdTest(Long id);
}