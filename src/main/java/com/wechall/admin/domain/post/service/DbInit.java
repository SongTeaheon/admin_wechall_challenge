package com.wechall.admin.domain.post.service;

import com.wechall.admin.domain.post.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DbInit implements CommandLineRunner {

    private PostRepository postRepository;

    public DbInit(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // log.info("add 20 datas of post");
        // for(long chg = 1L; chg <= 5; chg++) {
        //     for(long userNo = 1l; userNo <= 4; userNo++){
        //         this.postRepository.save(new Post(chg, userNo, "abdcd" + chg + " by " + userNo));
        //     }
        // }
    }
    
}