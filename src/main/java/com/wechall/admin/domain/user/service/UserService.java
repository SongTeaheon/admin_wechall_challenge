package com.wechall.admin.domain.user.service;

import java.util.List;
import java.util.stream.Collectors;

import com.wechall.admin.domain.user.model.dto.NewUserDto;
import com.wechall.admin.domain.user.model.dto.UserDetailDto;
import com.wechall.admin.domain.user.model.dto.UserNameChangeDto;
import com.wechall.admin.domain.user.model.entity.User;
import com.wechall.admin.domain.user.repository.UserRepository;
import com.wechall.admin.global.common.AgreeYn;
import com.wechall.admin.global.common.UserState;

public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDetailDto createUser(NewUserDto newUserDto){

        String profilePath = null; //이미지 

        User user = User.builder()
                        .userName(newUserDto.getName())
                        .profileImgPath(profilePath)
                        .userState(UserState.OK)
                        .pushAgreeYn(AgreeYn.No)
                        .build();
        
        user = userRepository.save(user);

        return new UserDetailDto(user);
    }

    public UserDetailDto getUserDtail(Long userNo){
        User user = userRepository.findByUserNo(userNo);
        return new UserDetailDto(user);
    }

    public List<UserDetailDto> getAllUser(){
        return userRepository.findAll().stream()
                                    .map(u -> new UserDetailDto(u))
                                    .collect(Collectors.toList());
    }

    public UserDetailDto modifyName(UserNameChangeDto userDto){
        User user = userRepository.findByUserNo(userDto.getUserNo());
        user.setUserName(userDto.getUserName());
        user = userRepository.save(user);
        return new UserDetailDto(user);
    }

    public void deleteUser(Long userNo){
        User user = userRepository.findByUserNo(userNo);
        user.setUserState(UserState.DELETED);
        user = userRepository.save(user);
    }
}