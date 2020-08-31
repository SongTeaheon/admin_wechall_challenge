package com.wechall.admin.domain.post.service;

import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class DbInit implements CommandLineRunner {

    private PostRepository postRepository;

    public DbInit(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("add 20 datas of post");
        for(int i = 0; i < 5; i++){
            this.postRepository.save(new Post(1L, 1L, "abdcd by " + i));
        }
        

    }
    
}