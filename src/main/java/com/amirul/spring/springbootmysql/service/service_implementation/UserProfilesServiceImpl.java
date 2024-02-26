package com.amirul.spring.springbootmysql.service.service_implementation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amirul.spring.springbootmysql.model.UserProfiles;
import com.amirul.spring.springbootmysql.repository.UserProfilesRepo;
import com.amirul.spring.springbootmysql.repository.UserRepo;
import com.amirul.spring.springbootmysql.service.UserProfilesService;

@Service
@Transactional
public class UserProfilesServiceImpl implements UserProfilesService {
    @Autowired
    UserProfilesRepo userProfilesRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public List<UserProfiles> findAll() {
        return userProfilesRepo.findAll();
    }

    @Override
    public String deleteUserProfiles(Long id) {
        userProfilesRepo.findById(id).orElseThrow(() -> new NoSuchElementException("There is no user profile of this id to be delete"));
        
        userProfilesRepo.deleteById(id);

        return "Deleted Successfully";
    }

    @Override
    public UserProfiles updateUserProfiles(UserProfiles userProfiles, Long id) {
        UserProfiles userProfilesDB = userProfilesRepo.findById(id).get();

        if (Objects.nonNull(userProfiles.getFirstName())) {
            userProfilesDB.setFirstName(userProfiles.getFirstName());
        }

        if (Objects.nonNull(userProfiles.getLastName())) {
            userProfilesDB.setLastName(userProfiles.getLastName());
        }

        if (Objects.nonNull(userProfiles.getBio())) {
            userProfilesDB.setBio(userProfiles.getBio());
        }

        if (Objects.nonNull(userProfiles.getAvatarUrl())) {
            userProfilesDB.setAvatarUrl(userProfiles.getAvatarUrl());
        }

        return userProfilesRepo.save(userProfilesDB);
    }

    @Override
    public UserProfiles findById(Long id) {
        return userProfilesRepo.findById(id).get();
    }

    @Override
    public UserProfiles save(UserProfiles userProfiles, Long id) {
        userProfiles.setUsers(userRepo.findById(id).get());
        return userProfilesRepo.save(userProfiles);
    }

    @Override
    public UserProfiles save(UserProfiles userProfiles) {
        return userProfilesRepo.save(userProfiles);
    }
    
}
