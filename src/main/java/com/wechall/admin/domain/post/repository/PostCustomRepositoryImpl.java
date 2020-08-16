package com.wechall.admin.domain.post.repository;

import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.model.entity.QPost;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PostCustomRepositoryImpl extends QuerydslRepositorySupport implements PostCustomRepository {


    public PostCustomRepositoryImpl(){
        super(Post.class);
    }

    public Post findByIdTest(Long id){
        QPost post = QPost.post;
        return from(post)
                  .where(post.postNo.eq(id))
                  .fetchOne();
    }


    
}