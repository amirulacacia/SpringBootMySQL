package com.amirul.spring.springbootmysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amirul.spring.springbootmysql.model.User;

@Service
public interface UserService {
    String deleteUser(Long id);

    User updateUserEnabled(User user, Long id);

    User updateUser(User user, Long id);

    User findById(Long id);

    List<User> findAll();

    User save(User user);
}
