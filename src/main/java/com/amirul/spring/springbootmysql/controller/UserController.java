package com.amirul.spring.springbootmysql.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amirul.spring.springbootmysql.model.User;
import com.amirul.spring.springbootmysql.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        if (Objects.isNull(user))
            throw new NullPointerException();

        return userService.save(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        return userService.updateUser(user, id);
    }

    @PutMapping("/enabled/{id}")
    public User updateUserEnabled(@RequestBody User user, @PathVariable("id") Long id) {
        return userService.updateUserEnabled(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/{userid}/add-permissions/{permissionsid}")
    public User assignPermissionsToUser(@PathVariable("userid") Long userId,
            @PathVariable("permissionsid") Long permissionId) {
        return userService.assignPermissionsToUser(userId, permissionId);
    }

    @PutMapping("/{userid}/remove-permissions/{permissionsid}")
    public User removePermissionsFromUser(@PathVariable("userid") Long userId,
            @PathVariable("permissionsid") Long permissionId) {
        return userService.removePermissionsFromUser(userId, permissionId);
    }

}
