package com.lms.application.service;

import com.lms.application.entity.BookCopy;
import com.lms.application.entity.User;

public interface UserService {
    boolean registerUser(User user);
    User find(Long userId);
}
