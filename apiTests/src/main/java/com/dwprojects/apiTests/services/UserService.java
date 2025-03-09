package com.dwprojects.apiTests.services;

import com.dwprojects.apiTests.domain.User;
import com.dwprojects.apiTests.domain.dto.UserDTO;

import java.util.List;

public interface UserService{
    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO userDTO);

    User update(UserDTO userDTO);
}
