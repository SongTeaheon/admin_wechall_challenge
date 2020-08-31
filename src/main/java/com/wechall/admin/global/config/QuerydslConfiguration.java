package com.wechall.admin.global.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuerydslConfiguration {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory JPAQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

}