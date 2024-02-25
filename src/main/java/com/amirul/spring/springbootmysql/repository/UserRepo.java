package com.amirul.spring.springbootmysql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amirul.spring.springbootmysql.model.User;

public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();
}
