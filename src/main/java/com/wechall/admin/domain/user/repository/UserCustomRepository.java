package com.wechall.admin.domain.user.repository;

import java.util.List;

import com.wechall.admin.domain.user.model.entity.User;

public interface UserCustomRepository {
    List<User> findByDynamicCondition(User userCondition);
}