package com.dwprojects.apiTests.services.impl;

import com.dwprojects.apiTests.domain.User;
import com.dwprojects.apiTests.repositories.UserRepository;
import com.dwprojects.apiTests.services.UserService;
import com.dwprojects.apiTests.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Object not found"));
    }
}
