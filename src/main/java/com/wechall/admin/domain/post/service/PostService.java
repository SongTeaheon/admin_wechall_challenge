package com.wechall.admin.domain.post.service;

import java.util.List;

import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.repository.PostRepository;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getPostList(){
        return postRepository.findAll();
    }

    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }
}