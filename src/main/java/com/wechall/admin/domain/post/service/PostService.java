package com.wechall.admin.domain.post.service;

import java.util.List;

import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.model.entity.PostImg;
import com.wechall.admin.domain.post.repository.PostImgRepository;
import com.wechall.admin.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {


    private final PostRepository postRepository;
    private final PostImgRepository postImgRepository;

    public PostService(PostRepository postRepository, PostImgRepository postImgRepository){
        this.postRepository = postRepository;
        this.postImgRepository = postImgRepository;
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

    public int savePostImg(List<PostImg> images){
        for(PostImg img : images){
            postImgRepository.save(img);
        }
        return images.size();
    }

    public List<Post> searchByConditions(Post post){
        return postRepository.findByDynamicCondition(post);
    }
}