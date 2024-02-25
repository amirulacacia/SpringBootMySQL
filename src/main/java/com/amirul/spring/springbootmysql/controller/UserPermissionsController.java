package com.amirul.spring.springbootmysql.controller;

import org.springframework.web.bind.annotation.RestController;

import com.amirul.spring.springbootmysql.model.UserPermissions;
import com.amirul.spring.springbootmysql.repository.UserPermissionsRepo;
import com.amirul.spring.springbootmysql.service.UserPermissionsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/{userid}/user_permissions/add/{id}")
    public UserPermissions createUserPermissions(@PathVariable("userid") Long userId, @PathVariable("id") Long permissionId) {
        return userPermissionsService.save(userId, permissionId);
    }
    
    @PutMapping("user_permissions/{id}/update/{permid}")
    public UserPermissions updateUserPermissions(@PathVariable("id") Long userPermissionsId, @PathVariable("permid") Long permissionId) {
        return userPermissionsService.updateUserPermissions(userPermissionsId, permissionId);
    }

    @PutMapping("user_permissions/{id}/remove/{permid}")
    public UserPermissions removePermissions(@PathVariable("id") Long userPermissionsId, @PathVariable("permid") Long permissionId) {
        return userPermissionsService.removePermissions(userPermissionsId, permissionId);
    }
    
    @DeleteMapping("/user_permissions/delete/{id}")
    public String deleteUserPermissions(@PathVariable Long id){
        return userPermissionsService.deleteUserPermissions(id);
    }

}
