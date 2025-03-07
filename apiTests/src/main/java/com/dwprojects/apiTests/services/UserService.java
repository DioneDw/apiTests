package com.dwprojects.apiTests.services;

import com.dwprojects.apiTests.domain.User;

public interface UserService{
    User findById(Integer id);
}
