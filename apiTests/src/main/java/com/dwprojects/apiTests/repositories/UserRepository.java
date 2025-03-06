package com.dwprojects.apiTests.repositories;

import com.dwprojects.apiTests.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
