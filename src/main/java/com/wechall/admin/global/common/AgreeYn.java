package com.wechall.admin.global.common;

import lombok.Getter;

@Getter
public enum AgreeYn {
    Yes("Y"),
    No("N");

    private String agreeYn;
    private AgreeYn(String agreeYn){
        this.agreeYn = agreeYn;
    }
}