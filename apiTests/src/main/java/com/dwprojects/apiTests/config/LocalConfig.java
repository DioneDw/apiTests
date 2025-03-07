package com.dwprojects.apiTests.config;

import com.dwprojects.apiTests.domain.User;
import com.dwprojects.apiTests.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public List<User> startDB(){
        User u1 = new User(null,"Teste1","teste1@teste.com","1234");
        User u2 = new User(null,"Teste2","teste2@teste.com","12345");

        return userRepository.saveAll(List.of(u1,u2));
    }
}
