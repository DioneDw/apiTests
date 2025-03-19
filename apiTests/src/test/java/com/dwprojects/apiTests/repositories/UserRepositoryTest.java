package com.dwprojects.apiTests.repositories;

import com.dwprojects.apiTests.domain.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    public static final String EMAIL = "testes@teste.com";
    public static final int ID = 1;
    public static final String NAME = "Teste";
    public static final String PASSWORD = "12346";

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository repository;

    private User user;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    @DisplayName("Test for find user by email with success")
    void findByEmail() {
        this.persistUser(user);
        Optional<User> userSearch = repository.findByEmail(EMAIL);

        assertThat(userSearch.isPresent()).isTrue();
        assertEquals(User.class, userSearch.get().getClass());
        assertEquals(EMAIL, userSearch.get().getEmail());
    }

    void persistUser(User user){
        entityManager.persist(user);
    }


    void startUser(){
        user = new User(null, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}