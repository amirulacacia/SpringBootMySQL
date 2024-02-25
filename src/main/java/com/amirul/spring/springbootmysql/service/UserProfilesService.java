package com.amirul.spring.springbootmysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amirul.spring.springbootmysql.model.UserProfiles;

@Service
public interface UserProfilesService {
    List<UserProfiles> findAll();

    String deleteUserProfiles(Long id);

    UserProfiles updateUserProfiles(UserProfiles userProfiles, Long id);

    UserProfiles findById(Long id);

    UserProfiles save(UserProfiles userProfiles, Long id);
    UserProfiles save(UserProfiles userProfiles);
}
