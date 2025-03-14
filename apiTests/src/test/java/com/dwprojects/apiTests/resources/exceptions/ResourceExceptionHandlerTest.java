package com.dwprojects.apiTests.resources.exceptions;

import com.dwprojects.apiTests.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceExceptionHandlerTest {

    @InjectMocks
    private ResourceExceptionHandler resourceExceptionHandler;

    @Mock
    private StandardError standardError;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void whenObjectNotFoundExceptionThenReturnAnResponseEntity() {
        assertThrows(ObjectNotFoundException.class, () -> {
            
        });
    }

    @Test
    void dataIntegratyViolation() {
    }

    private void startException(){

    }
}