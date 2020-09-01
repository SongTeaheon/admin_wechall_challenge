package com.wechall.admin.domain.user.repository;

import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.wechall.admin.domain.user.model.entity.QUser;
import com.wechall.admin.domain.user.model.entity.User;
import com.wechall.admin.global.common.UserState;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserCustomRepositoryImpl extends QuerydslRepositorySupport  implements UserCustomRepository{
    
    public UserCustomRepositoryImpl(){
        super(User.class);
    }
    
    @Override
    public List<User> findByDynamicCondition(User userCondition){
        QUser user = QUser.user;
        return from(user)
                .where(eqUserNo(userCondition.getUserNo()),
                    eqUserState(userCondition.getUserState()),
                    eqName(userCondition.getUserName())
                    )
                .fetch();
    }

    private BooleanExpression eqUserNo(Long userNo){
        if(userNo == null) return null;
        return QUser.user.userNo.eq(userNo);
    }

    private BooleanExpression eqUserState(UserState userState){
        if(userState == null) return null;
        return QUser.user.userState.eq(userState);
    }

    private BooleanExpression eqName(String name){
        if(name == null) return null;
        return QUser.user.userName.eq(name);
    }
}