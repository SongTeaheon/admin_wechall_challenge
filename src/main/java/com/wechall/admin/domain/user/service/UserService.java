package com.wechall.admin.domain.user.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.wechall.admin.domain.user.model.dto.NewUserDto;
import com.wechall.admin.domain.user.model.dto.UserChangeDto;
import com.wechall.admin.domain.user.model.dto.UserDetailDto;
import com.wechall.admin.domain.user.model.entity.User;
import com.wechall.admin.domain.user.repository.UserRepository;
import com.wechall.admin.global.common.AgreeYn;
import com.wechall.admin.global.common.Constant;
import com.wechall.admin.global.common.UserState;
import com.wechall.admin.global.util.ImageStoreService;

public class UserService {
    
    private final UserRepository userRepository;
    private final ImageStoreService imageStoreService;

    public UserService(UserRepository userRepository, ImageStoreService imageStoreService){
        this.userRepository = userRepository;
        this.imageStoreService = imageStoreService;
    }

    public UserDetailDto createUser(NewUserDto newUserDto) throws IOException{

        String profilePath = null; //이미지 
        if(newUserDto.getImgTempPath() != null){
            profilePath = copyImage(newUserDto.getImgTempPath());
        }

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

    public UserDetailDto modifyUser(UserChangeDto userDto) throws IOException{
        User user = userRepository.findByUserNo(userDto.getUserNo());

        user.setUserName(userDto.getUserName());
        if(userDto.isImageChanged()){
            String imagePath = copyImage(userDto.getTempImgPath());
            user.setProfileImgPath(imagePath);
        }

        user = userRepository.save(user);
        return new UserDetailDto(user);
    }

    public void deleteUser(Long userNo){
        User user = userRepository.findByUserNo(userNo);
        user.setUserState(UserState.DELETED);
        user = userRepository.save(user);
    }

    private String copyImage(String tempImagePath) throws IOException{
        File file = imageStoreService.copyFile(tempImagePath, imageStoreService.getRealPath(Constant.IMG_PATH_PROFILE));
        return file.getAbsolutePath();
    }

    public List<UserDetailDto> searchByConditions(User user){
        return userRepository.findByDynamicCondition(user).stream()     
                                        .map(s -> new UserDetailDto(s))
                                        .collect(Collectors.toList());
    }
}