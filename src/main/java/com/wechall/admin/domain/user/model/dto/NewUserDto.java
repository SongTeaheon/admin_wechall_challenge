package com.wechall.admin.domain.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewUserDto {
    private String name;
    private String imgTempPath;
}