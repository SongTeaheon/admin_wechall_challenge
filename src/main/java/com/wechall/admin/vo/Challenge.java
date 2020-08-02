package com.wechall.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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

    public Challenge(int challengeSeqno) {
        this.challengeSeqno = challengeSeqno;
    }
}