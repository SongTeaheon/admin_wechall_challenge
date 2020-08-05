package com.wechall.admin.domain.challenge.repository;

import java.util.List;

import com.wechall.admin.domain.challenge.model.entity.Challenge;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    /**
     * @apiNote 챌린지 전체 목록 조회
     * @return List<Challenge>
     */
    public List<Challenge> findAll();
}