package com.dwprojects.apiTests.services.impl;

import com.dwprojects.apiTests.domain.User;
import com.dwprojects.apiTests.domain.dto.UserDTO;
import com.dwprojects.apiTests.repositories.UserRepository;
import com.dwprojects.apiTests.services.exceptions.DataIntegratyViolationException;
import com.dwprojects.apiTests.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final String NAME = "DioneTest";
    public static final String EMAIL = "dioneteste@teste.com";
    public static final String PASSWORD = "1234";
    public static final int ID = 1;
    public static final String MESSAGE = "Object not found";
    public static final int INDEX = 0;
    public static final String MESSAGE2 = "E-mail já cadastrado no sistema";
    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    private User user;

    private UserDTO userDTO;

    private Optional<User> optionalUser;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        User response = service.findById(ID);
        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(MESSAGE));
        try {
            service.findById(ID);
        } catch (Exception e) {
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals(MESSAGE, e.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfUsers() {
        when(repository.findAll()).thenReturn(List.of(user));
        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
        assertEquals(PASSWORD, response.get(INDEX).getPassword());
    }

    @Test
    void whenCreateThenReturnSucess(){
        when(repository.save(any())).thenReturn(user);

        User response = service.create(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenCreateThenReturnAnDataIntegratyViolationException(){
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try{
            optionalUser.get().setId(2);
            service.create(userDTO);
        }catch(Exception e){
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals("E-mail já cadastrado no sistema", e.getMessage());
        }
    }

    @Test
    void whenUpdateThenReturnSucess(){
        when(repository.save(any())).thenReturn(user);

        User response = service.update(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenUpdateThenReturnAnDataIntegratyViolationException(){
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try{
            optionalUser.get().setId(2);
            service.update(userDTO);
        }catch(Exception e){
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals("E-mail já cadastrado no sistema", e.getMessage());
        }
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}