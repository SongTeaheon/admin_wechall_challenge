package com.wechall.admin.domain.user.model.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wechall.admin.global.common.AgreeYn;
import com.wechall.admin.global.common.UserState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "WC_USER_TB", schema = "WE_CHALL")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_NO")
    private Long userNo;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name ="PROFILE_IMG_PATH")
    private String profileImgPath;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "USER_STATE", nullable = false)
    private UserState userState;

    @Column(name="KAKAO_REFRESH_TOKEN")
    private String kakaoRefreshToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "PUSH_AGREE_YN")
    private AgreeYn pushAgreeYn;

    @Column(name = "PUSH_AGREE_TIME", nullable = true)
    private Time pushAgreeTime;

    @CreationTimestamp
    @Column(name = "REG_TIME")
    private Time regTime;

    @UpdateTimestamp
    @Column(name = "CHG_TIME")
    private Time chgTime;


    public User(){}
    public User(String name){
        this.userName = name;
    }

    public void setUserState(UserState userState){
        this.userState = userState;
    }

    public void setProfileImgPath(String path){
        this.profileImgPath = path;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPushAgreeYn(AgreeYn pushAgreeYn) {
        this.pushAgreeYn = pushAgreeYn;
    }

    public void setPushAgreeTime(Time pushAgreeTime) {
        this.pushAgreeTime = pushAgreeTime;
    }

    public void setKakaoRefreshToken(String kakaoRefreshToken) {
        this.kakaoRefreshToken = kakaoRefreshToken;
    }

    

}