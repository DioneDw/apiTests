package com.dwprojects.apiTests.services.impl;

import com.dwprojects.apiTests.domain.User;
import com.dwprojects.apiTests.domain.dto.UserDTO;
import com.dwprojects.apiTests.repositories.UserRepository;
import com.dwprojects.apiTests.services.UserService;
import com.dwprojects.apiTests.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        return repository.save(mapper.map(userDTO,User.class));
    }
}
