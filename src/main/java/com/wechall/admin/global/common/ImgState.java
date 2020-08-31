package com.wechall.admin.global.common;

import lombok.Getter;

@Getter
public enum ImgState {
    OK(0L),
    DELETED(1L);

    private Long imgState;
    ImgState(Long imgState){
        this.imgState = imgState;
    }
}