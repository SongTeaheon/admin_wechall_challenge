package com.wechall.admin.domain.challenge.service;

import java.util.List;

import com.wechall.admin.domain.challenge.model.entity.Challenge;
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
    public List<Challenge> getChallengeList() {
        return challengeRepository.findAll();
    }
}