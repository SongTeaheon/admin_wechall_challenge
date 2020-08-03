package com.wechall.admin.domain.challenge.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Challenge {
    
	private long challengeSeqno;
    private String challengeName;

    public Challenge() {
	}

    public Challenge(int challengeSeqno, String challengeName) {
        this.challengeSeqno = challengeSeqno;
        this.challengeName = challengeName;
    }
}