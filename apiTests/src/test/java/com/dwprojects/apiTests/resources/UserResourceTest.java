package com.dwprojects.apiTests.resources;

import com.dwprojects.apiTests.domain.User;
import com.dwprojects.apiTests.domain.dto.UserDTO;
import com.dwprojects.apiTests.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserResourceTest {

    public static final int ID = 1;
    public static final String NAME = "DioneTest";
    public static final String EMAIL = "dioneteste@teste.com";
    public static final String PASSWORD = "1234";

    @InjectMocks
    private UserResource resource;

    @Mock
    private UserServiceImpl serviceImpl;

    @Mock
    private ModelMapper modelMapper;


    private User user;

    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }

}