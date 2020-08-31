package com.wechall.admin.domain.user.model.dto;

import com.wechall.admin.domain.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDetailDto {
    private Long userNo;
    private String name;
    private String profileImgPath;

    public UserDetailDto(User user){
        this.userNo = user.getUserNo();
        this.name = user.getUserName();
        this.profileImgPath = user.getProfileImgPath();
    }
}