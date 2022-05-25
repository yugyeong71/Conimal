package com.example.api_conimal.user.repository;

import com.example.api_conimal.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
