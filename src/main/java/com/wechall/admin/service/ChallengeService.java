package com.wechall.admin.service;

import java.util.Arrays;
import java.util.List;

import com.wechall.admin.vo.Challenge;

public class ChallengeService {
    /**
     * @apiNote 챌린지 목록을 가져옴
     * @param
     * @return List<Challenge>
     */
    public List<Challenge> getChallenge() {
        return Arrays.asList(new Challenge());
    }

    /** 
     * @apiNote 챌린지 단건 정보를 가져옴
     * @param
     * @return Challenge
     */
    public Challenge getChallengeInfo(int challengSeqno) {
        return new Challenge(challengSeqno);
    }

    /** 
     * @apiNote 챌린지 정보를 등록
     * @param
     * @return
     */
	public Challenge insertChallenge() {
		return null;
	}
}