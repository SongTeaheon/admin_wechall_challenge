package com.wechall.admin.domain.post.service;

import com.wechall.admin.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    
    private final PostRepository postRepository;

    public TestService(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    
    public String test(){
        //List<Post> list = postRepository.findAll();
        return "testsss";
    }
}