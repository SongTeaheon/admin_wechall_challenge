package com.wechall.admin.domain.post.model.dto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.wechall.admin.domain.post.model.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDetailDto {
    private Long postNo;
    private Long challengeNo;
    private Long userNo;
    private String contents;
    private Date registDate;
    private Date changeDate;
    List<String> images;

    public PostDetailDto(Post post){
        this.postNo = post.getPostNo();
        this.challengeNo = post.getChallengeNo();
        this.userNo = post.getUserNo();
        this.contents = post.getContents();
        this.registDate = post.getRegistDate();
        this.changeDate = post.getChangeDate();
        this.images = post.getImages().stream()
                                    .map(s -> s.getImgPath())
                                    .collect(Collectors.toList());
    }

}