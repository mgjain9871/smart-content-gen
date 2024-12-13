package com.example.smart_content_gen.dao;

import com.example.smart_content_gen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

        User findByUsername(String username);
}
