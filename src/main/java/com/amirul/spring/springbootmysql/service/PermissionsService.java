package com.amirul.spring.springbootmysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amirul.spring.springbootmysql.model.Permissions;

@Service
public interface PermissionsService {
    List<Permissions> findAll();
    
    Permissions findById(Long id);

    Permissions save(Permissions permissions);

    Permissions updatePermissions(Permissions permissions, Long id);

    String deletePermissions(Long id);
}
