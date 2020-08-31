package com.wechall.admin.domain.user.repository;

import java.util.List;

import com.wechall.admin.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    <S extends User> S save(S user);
    User findByUserNo(Long userNo);
}