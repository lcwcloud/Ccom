package com.cc.service;

import com.cc.model.UserT;

public interface UserTService {
    public UserT getUserById(int userId);

    public int insertUser(UserT userT);
}
