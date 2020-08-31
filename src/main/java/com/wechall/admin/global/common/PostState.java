package com.wechall.admin.global.common;

import lombok.Getter;

@Getter
public enum PostState {
    OK(0L),
    DELETED(1L);

    private Long postState;
    PostState(Long postState){
        this.postState = postState;
    }
}