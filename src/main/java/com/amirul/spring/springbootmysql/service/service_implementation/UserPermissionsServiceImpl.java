package com.amirul.spring.springbootmysql.service.service_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amirul.spring.springbootmysql.model.UserPermissions;
import com.amirul.spring.springbootmysql.repository.PermissionsRepo;
import com.amirul.spring.springbootmysql.repository.UserPermissionsRepo;
import com.amirul.spring.springbootmysql.repository.UserRepo;
import com.amirul.spring.springbootmysql.service.UserPermissionsService;

@Service
@Transactional
public class UserPermissionsServiceImpl implements UserPermissionsService {
    @Autowired
    UserPermissionsRepo userPermissionsRepo;
    @Autowired
    PermissionsRepo permissionsRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public List<UserPermissions> findAll() {
        return userPermissionsRepo.findAll();
    }

    @Override
    public UserPermissions findById(Long id) {
        return userPermissionsRepo.findById(id).get();
    }

    @Override
    public UserPermissions save(Long userId, Long permissionId) {
        UserPermissions userPermissions = new UserPermissions();

        userPermissions.setUser(userRepo.findById(userId).get());
        userPermissions.setPermissions(permissionsRepo.findById(permissionId).get());
        
        return userPermissionsRepo.save(userPermissions);
    }

    @Override
    public UserPermissions updateUserPermissions(Long userPermissionsId, Long permissionId) {

        UserPermissions userPermissionsDB = userPermissionsRepo.findById(userPermissionsId).get();
        
        userPermissionsDB.setPermissions(permissionsRepo.findById(permissionId).get());

        return userPermissionsRepo.save(userPermissionsDB);
    }

    @Override
    public UserPermissions removePermissions(Long userPermissionsId, Long permissionId) {

        UserPermissions userPermissionsDB = userPermissionsRepo.findById(userPermissionsId).get();
        
        userPermissionsDB.removePermissions(permissionsRepo.findById(permissionId).get());

        return userPermissionsRepo.save(userPermissionsDB);
    }

    @Override
    public String deleteUserPermissions(Long id) {
        userPermissionsRepo.deleteById(id);;
        return "Deleted Successfully";
    }
    
}
