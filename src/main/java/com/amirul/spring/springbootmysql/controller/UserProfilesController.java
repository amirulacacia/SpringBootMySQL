package com.amirul.spring.springbootmysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amirul.spring.springbootmysql.model.UserProfiles;
import com.amirul.spring.springbootmysql.repository.UserProfilesRepo;
import com.amirul.spring.springbootmysql.service.UserProfilesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
@Controller
public class UserProfilesController {
    @Autowired
    UserProfilesRepo userProfilesRepo;
    @Autowired
    UserProfilesService userProfilesService;

    @GetMapping("/profiles")
    public List<UserProfiles> getAllProfiles() {
        return userProfilesService.findAll();
    }

    @GetMapping("/profiles/{id}")
    public UserProfiles getProfilesById(@PathVariable Long id) {
        return userProfilesService.findById(id);
    }
    
    @PostMapping("/{id}/profiles/add")
    public UserProfiles addProfiles(@RequestBody UserProfiles userProfiles, @PathVariable("id") Long id) {
        return userProfilesService.save(userProfiles, id);
    }

    @PutMapping("/profiles/update/{id}")
    public UserProfiles updateUser(@RequestBody UserProfiles userProfiles, @PathVariable("id") Long id) {
        return userProfilesService.updateUserProfiles(userProfiles, id);
    }

    @DeleteMapping("/profiles/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return userProfilesService.deleteUserProfiles(id);
    }
    
}
