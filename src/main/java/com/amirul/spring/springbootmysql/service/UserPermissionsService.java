package com.amirul.spring.springbootmysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amirul.spring.springbootmysql.model.UserPermissions;

@Service
public interface UserPermissionsService {
    List<UserPermissions> findAll();

    UserPermissions findById(Long id);
}
