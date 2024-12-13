package com.example.smart_content_gen.service;

import com.example.smart_content_gen.dao.UserRepository;
import com.example.smart_content_gen.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
