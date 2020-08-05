package com.wechall.admin.domain.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "WE_CHALL.WC_CHALLENGE_TB")
public class Challenge implements Serializable {
    private static final long serialVersionUID = -8696423130454394004L;

    @Id
    @Column(name = "CLG_NO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long challengeNo;

    @Column(name = "CLG_NM", nullable = false)
    private String challengeName;

    @Column(name = "CLG_TP", nullable = false)
    private String challengeType ;

    @Column(name = "CLG_ST", nullable = false)
    private String challengeState;

    @Column(name = "SRT_DT", nullable = false)
    private String startDate;

    @Column(name = "END_DT", nullable = false)
    private String endDate;

    @Column(name = "JOIN_EXPN", nullable = true)
    private String joinExplain;

    @Column(name = "INTRO_CONT", nullable = true)
    private String introContents;

    @Column(name = "REG_USER_NO", nullable = false)
    private String registUserNo;

    @Column(name = "REG_DT", nullable = false)
    private String registDate;

    @Column(name = "CHG_USER_NO", nullable = true)
    private String changeUserNo;

    @Column(name = "CHG_DT", nullable = true)
    private String changeDate;


    public Challenge() {
    }

    public Challenge(Long challengeNo, String challengeName) {
        this.challengeNo = challengeNo;
        this.challengeName = challengeName;
    }
}