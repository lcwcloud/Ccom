package com.cc.service.impl;

import com.cc.dao.UserTDAO;
import com.cc.model.UserT;
import com.cc.service.UserTService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userTService")
public class UserTServiceImpl implements UserTService {
    @Resource
    private UserTDAO userTDAO;

    @Override
    public UserT getUserById(int userId) {
        return this.userTDAO.selectByPrimaryKey(userId);
    }

    @Override
    public int insertUser(UserT userT) {
        return this.userTDAO.insert(userT);
    }
}
