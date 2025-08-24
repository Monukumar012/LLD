package com.lms.application.service;

import com.lms.application.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private final Map<Long, User> users;

    // Get Singleton Instance
    public static UserService getInstance(){
        return UserServiceImpl.UserServiceInstance.INSTANCE;
    }
    private static class UserServiceInstance{
        private static final UserService INSTANCE = new UserServiceImpl();
    }

    @Override
    public boolean registerUser(User user) {
        return users.put(user.getUserId(), user) != null;
    }

    @Override
    public User find(Long userId) {
        User user = users.get(userId);
        if(user == null){
            throw new RuntimeException("User not found with id : "+userId);
        }
        return user;
    }

    {
        users = new HashMap<>();
    }
}
