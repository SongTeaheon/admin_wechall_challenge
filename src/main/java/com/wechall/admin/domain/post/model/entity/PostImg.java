package com.wechall.admin.domain.post.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Builder
@Table(name="WC_POST_IMG_TB")
public class PostImg {
    
    @Id
    @Column(name="IMG_NO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imgNo;

    @ManyToOne
    private Post post;

    @Column(name="IMG_PATH", nullable = false)
    private String imgPath;

    @Column(name="THUMBNAIL_PATH")
    private String thumnailPath;

    @Column(name = "REG_TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date registDate;

    @Column(name = "CHG_TIME" , columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date changeDate;

    @Column(name="IMG_STATE", columnDefinition = "INTEGER DEFAULT '0'")
    private Long imgState;

}