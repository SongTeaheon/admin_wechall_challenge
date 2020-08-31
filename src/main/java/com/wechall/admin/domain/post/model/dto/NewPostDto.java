package com.wechall.admin.domain.post.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class NewPostDto {
    private Long postNo;
    private Long challengeNo;
    private Long userNo;
    private String contents;
    List<String> images = new ArrayList<>();

    @Override
    public String toString(){
        return "newPost : " + challengeNo + userNo+ contents + images.get(0);
    }
}