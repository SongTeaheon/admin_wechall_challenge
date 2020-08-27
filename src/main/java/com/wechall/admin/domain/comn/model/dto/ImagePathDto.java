package com.wechall.admin.domain.comn.model.dto;

import lombok.Getter;

@Getter
public class ImagePathDto {
    private String imagePath;

    public ImagePathDto(String path){
        this.imagePath = path;
    }
}