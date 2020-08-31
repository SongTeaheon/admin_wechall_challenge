package com.wechall.admin.domain.post.repository;

import java.util.List;

import com.wechall.admin.domain.post.model.entity.Post;

public interface PostCustomRepository {
    List<Post> findByDynamicCondition(Post post);
}