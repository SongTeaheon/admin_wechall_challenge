package com.wechall.admin.domain.challenge.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WC_CHALLENGE_TB", schema = "WE_CHALL")
public class Challenge implements Serializable {
    private static final long serialVersionUID = -8696423130454394004L;

    @Id
    @Column(name = "CLG_NO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long challengeNo;

    @Column(name = "CLG_NM")
    private String challengeName;

    @Column(name = "CLG_TP")
    private String challengeType ;

    @Column(name = "CLG_ST")
    private String challengeState;

    @Column(name = "SRT_DT")
    private Date startDate;

    @Column(name = "END_DT")
    private Date endDate;

    @Column(name = "JOIN_EXPN")
    private String joinExplain;

    @Column(name = "INTRO_CONT")
    private String introContents;

    @Column(name = "REG_USER_NO")
    private Long registUserNo;

    @Column(name = "REG_DT")
    private Date registDate;

    @Column(name = "CHG_USER_NO")
    private Long changeUserNo;

    @Column(name = "CHG_DT")
    private Date changeDate;


    public Challenge() {
    }

    public Challenge(Long challengeNo, String challengeName) {
        this.challengeNo = challengeNo;
        this.challengeName = challengeName;
    }

    @Override
    public String toString() {
        return 
            "챌린지번호 : " + this.challengeNo + "\n" +
            "챌린지명 : " + this.challengeName + "\n" +
            "챌린지상태 : " + this.challengeState + "\n" +
            "챌린지타입 : " + this.challengeType + "\n" +
            "등록시간 : " + this.registDate + "\n"
        ;
    }
}