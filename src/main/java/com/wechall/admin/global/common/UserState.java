package com.wechall.admin.global.common;

import lombok.Getter;

@Getter
public enum UserState {
    OK(0L),
    DELETED(1L);

    private Long userState;
    UserState(Long userState){
        this.userState = userState;
    }
    
}