package com.wechall.admin.domain.post.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="WC_POST_IMG_TB")
public class PostImg {
    
    @Id
    @Column(name="IMG_NO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imgNo;

    @ManyToOne
    @JoinColumn(name="POST_NO", nullable=false)
    private Post post;

    @Column(name="IMG_PATH", nullable = false)
    private String imgPath;

    @Column(name="SEQ", nullable = false)
    private Long seq;

    @Column(name = "REG_TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date registDate;

    @Column(name = "CHG_TIME" , columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date changeDate;

    @Column(name="IMG_STATE", columnDefinition = "INTEGER DEFAULT '0'")
    private Long imgState;

    public void setPost(Post post){
        this.post = post;
    }

}