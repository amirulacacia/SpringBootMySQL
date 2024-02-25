package com.amirul.spring.springbootmysql.controller;

import org.springframework.web.bind.annotation.RestController;

import com.amirul.spring.springbootmysql.model.Permissions;
import com.amirul.spring.springbootmysql.repository.PermissionsRepo;
import com.amirul.spring.springbootmysql.service.PermissionsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/permissions")
@Controller
public class PermissionsController {
    @Autowired
    PermissionsRepo permissionsRepo;
    @Autowired
    PermissionsService permissionsService;

    @GetMapping("/all")
    public List<Permissions> getAllPermissions() {
        return permissionsService.findAll();
    }

    @GetMapping("/{id}")
    public Permissions getPermissionsById(@PathVariable Long id) {
        return permissionsService.findById(id);
    }

    @PostMapping("/create")
    public Permissions createPermissions(@RequestBody Permissions permissions) {
        return permissionsService.save(permissions);
    }
    
    @PutMapping("/update/{id}")
    public Permissions updatePermissions(@RequestBody Permissions permissions, @PathVariable Long id) {
        return permissionsService.updatePermissions(permissions, id);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deletePermissions(@PathVariable Long id){
        return permissionsService.deletePermissions(id);
    }
}
