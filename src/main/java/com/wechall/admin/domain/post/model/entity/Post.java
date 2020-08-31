package com.wechall.admin.domain.post.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wechall.admin.global.common.PostState;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name="WC_POST_TB", schema="WE_CHALL")
public class Post {

    @Id
    @Column(name = "POST_NO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postNo;
    
    @Column(name = "CLG_NO", nullable = false)
    private Long challengeNo;

    @Column(name = "USER_NO", nullable = false)
    private Long userNo;

    @Column(name = "CONT")
    private String contents;

    @Column(name = "REG_TIME")
    @CreationTimestamp
    private Date registDate;

    @Column(name = "CHG_TIME")
    @UpdateTimestamp
    private Date changeDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "POST_STATE")
    private PostState postState;

    @OneToMany(mappedBy = "post")
    List<PostImg> images;

    public Post(){}
    public Post(Long challengeNo, Long userNo, String cont){
        this.challengeNo = challengeNo;
        this.userNo = userNo;
        this.contents = cont;
    }

    @Override
    public String toString(){
        return 
            "포스트번호 : " + this.postNo + "\n" +
            "챌린지번호 : " + this.challengeNo + "\n" +
            "작성자 : " + this.userNo + "\n" +
            "내용 : " + this.contents + "\n" +
            "등록시간 : " + this.registDate + "\n" +
            "수정시간 : " + this.changeDate + "\n" +
            "포스트상태 : " + this.postState
        ;
    }
    
    public void setImages(List<PostImg> images){
        this.images = images;
    }

    public void setContents(String contents){
        this.contents = contents;
    }

    public void setPostState(PostState state){
        this.postState = state;
    }
}