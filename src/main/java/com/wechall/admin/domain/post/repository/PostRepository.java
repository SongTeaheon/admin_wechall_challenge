package com.wechall.admin.domain.post.repository;

import java.util.List;

import com.wechall.admin.domain.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository {
    List<Post> findAll();
    List<Post> findByChallengeNo(Long challengeNo);
    <S extends Post> S save(S post);
    Post findByPostNo(Long postNo);
   
}