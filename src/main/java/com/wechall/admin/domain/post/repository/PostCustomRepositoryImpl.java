package com.wechall.admin.domain.post.repository;

import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.wechall.admin.domain.post.model.entity.Post;
import com.wechall.admin.domain.post.model.entity.QPost;
import com.wechall.admin.global.common.PostState;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PostCustomRepositoryImpl extends QuerydslRepositorySupport implements PostCustomRepository {


    public PostCustomRepositoryImpl(){
        super(Post.class);
    }

	@Override
	public List<Post> findByDynamicCondition(Post postCond) {
        QPost post = QPost.post;
        return from(post)
                .where( eqPostNo(postCond.getPostNo()),
                        eqChallengeNo(postCond.getChallengeNo()),
                        eqUserNo(postCond.getUserNo()),
                        eqPostState(postCond.getPostState()),
                        containsContents(postCond.getContents()))
                .fetch();
    }
    
    private BooleanExpression eqPostNo(Long postNo){
        if(postNo == null) return null;
        return QPost.post.postNo.eq(postNo);
    }

    private BooleanExpression eqChallengeNo(Long challengeNo){
        if(challengeNo == null) return null;
        return QPost.post.challengeNo.eq(challengeNo);
    }

    private BooleanExpression eqUserNo(Long userNo){
        if(userNo == null) return null;
        return QPost.post.userNo.eq(userNo);
    }

    private BooleanExpression eqPostState(PostState postState){
        if(postState == null) return null;
        return QPost.post.postState.eq(postState);
    }

    private BooleanExpression containsContents(String contents){
        if(contents == null)return null;
        return QPost.post.contents.contains(contents);
    }

    



    
}