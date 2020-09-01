package com.wechall.admin.domain.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserChangeDto {
    private Long userNo;
    private String userName;
    private String tempImgPath;
    private Boolean imgChangeYn;

    public boolean isImageChanged(){
        if(imgChangeYn != null && imgChangeYn){
            return true;
        }
        return false;
    }
}