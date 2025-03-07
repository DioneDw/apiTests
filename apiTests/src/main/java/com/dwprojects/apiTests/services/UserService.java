package com.dwprojects.apiTests.services;

import com.dwprojects.apiTests.domain.User;

import java.util.List;

public interface UserService{
    User findById(Integer id);

    List<User> findAll();
}
