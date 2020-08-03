package com.wechall.admin.domain.challenge.service;

import java.util.List;

import com.wechall.admin.domain.challenge.model.vo.Challenge;
import com.wechall.admin.domain.challenge.repository.ChallengeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeService(final ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    /**
     * @apiNote 챌린지 목록을 가져옴
     * @param
     * @return List<Challenge>
     */
    public List<Challenge> getChallenge() {
        return challengeRepository.selectChallenge();
    }

    /** 
     * @apiNote 챌린지 단건 정보를 가져옴
     * @param
     * @return Challenge
     */
    public Challenge getChallengeInfo(int challengSeqno) {
        return new Challenge(challengSeqno, "test");
    }

    /** 
     * @apiNote 챌린지 정보를 등록
     * @param
     * @return
     */
	public void insertChallenge() {
	}

    /** 
     * @apiNote 챌린지 정보를 수정
     * @param
     * @return
     */
	public void registChallengeInfo(int challengeSeqno) {
	}

    /** 
     * @apiNote 챌린지 정보를 삭제
     * @param
     * @return
     */
	public void modifyChallengeInfo(int challengeSeqno) {
	}
}