package com.wechall.admin.domain.challenge.repository;

import java.util.List;

import com.wechall.admin.domain.challenge.model.entity.Challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    /**
     * @apiNote 챌린지 전체 목록 조회
     * @return List<Challenge>
     */
    public List<Challenge> findAll();

    /**
     * @apiNote 챌린지번호로 챌린지 조회
     * @return
     */
    public Challenge findAllById(Long challengeNo);
    
    /**
     * @apiNote 챌린지번호로 챌린지 조회(jpa query)
     * @return List<Challenge>
     */
    @Query("SELECT m FROM Member m WHERE m.name = :name")
    public Challenge findByName2(@Param("name") long challengeNo);

    /**
     * @apiNote 챌린지번호로 챌린지 조회(native query)
     * @return List<Challenge>
     */
    @Query(value = "SELECT * FROM Member WHERE name = ?0", nativeQuery = true)
    public Challenge findByName1(long challengeNo);

	
}