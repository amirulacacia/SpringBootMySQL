package com.amirul.spring.springbootmysql.controller;

import org.springframework.web.bind.annotation.RestController;

import com.amirul.spring.springbootmysql.model.UserPermissions;
import com.amirul.spring.springbootmysql.repository.UserPermissionsRepo;
import com.amirul.spring.springbootmysql.service.UserPermissionsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
@Controller
public class UserPermissionsController {
    @Autowired
    UserPermissionsRepo userPermissionsRepo;
    @Autowired
    UserPermissionsService userPermissionsService;

    @GetMapping("/user_permissions")
    public List<UserPermissions> getAllUserPermissions() {
        return userPermissionsService.findAll();
    }

    @GetMapping("/user_permissions/{id}")
    public UserPermissions getUserPermissionsById(@PathVariable Long id) {
        return userPermissionsService.findById(id);
    }
}
