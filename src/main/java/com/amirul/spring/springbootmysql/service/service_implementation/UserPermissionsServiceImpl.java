package com.amirul.spring.springbootmysql.service.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amirul.spring.springbootmysql.model.UserPermissions;
import com.amirul.spring.springbootmysql.repository.UserPermissionsRepo;
import com.amirul.spring.springbootmysql.service.UserPermissionsService;

@Service
@Transactional
public class UserPermissionsServiceImpl implements UserPermissionsService {
    @Autowired
    UserPermissionsRepo userPermissionsRepo;

    @Override
    public List<UserPermissions> findAll() {
        return userPermissionsRepo.findAll();
    }

    @Override
    public UserPermissions findById(Long id) {
        return userPermissionsRepo.findById(id).get();
    }
}
