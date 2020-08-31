package com.wechall.admin.domain.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNameChangeDto {
    private Long userNo;
    private String userName;
}