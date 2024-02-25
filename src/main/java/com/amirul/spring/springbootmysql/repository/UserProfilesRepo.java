package com.amirul.spring.springbootmysql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amirul.spring.springbootmysql.model.UserProfiles;

public interface UserProfilesRepo extends CrudRepository<UserProfiles, Long> {
    List<UserProfiles> findAll();
}
