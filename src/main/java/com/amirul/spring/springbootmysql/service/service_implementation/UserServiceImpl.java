package com.amirul.spring.springbootmysql.service.service_implementation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amirul.spring.springbootmysql.model.Permissions;
import com.amirul.spring.springbootmysql.model.User;
import com.amirul.spring.springbootmysql.repository.PermissionsRepo;
import com.amirul.spring.springbootmysql.repository.UserRepo;
import com.amirul.spring.springbootmysql.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PermissionsRepo permissionsRepo;

    @Override
    public List<User> findAll(){
        return userRepo.findAll();
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findById(Long id) {
       return userRepo.findById(id).get();
    }

    @Override
    public User updateUser(User user, Long id) {
        User userDB = userRepo.findById(id).get();

        if (Objects.nonNull(user.getUsername())) {
            userDB.setUsername(user.getUsername());
        }

        if (Objects.nonNull(user.getPassword())) {
            userDB.setPassword(user.getPassword());
        }

        if (Objects.nonNull(user.getEmail())) {
            userDB.setEmail(user.getEmail());
        }
        
        return userRepo.save(userDB);
    }

    @Override
    public User updateUserEnabled(User user, Long id) {
        User userDB = userRepo.findById(id).get();
        
        if (Objects.nonNull(user.getEnabled())) {
            userDB.setEnabled(user.getEnabled());
        }

        return userRepo.save(userDB);
    }

    @Override
    public String deleteUser(Long id) {
        userRepo.findById(id).orElseThrow(() -> new NoSuchElementException("There is no user of this id to be delete"));

        userRepo.deleteById(id);

        return "Delete Successfully";
    }

    @Override
    public User assignPermissionsToUser(Long userId, Long permissionId) {
        Set<Permissions> permissionsSet = null;
        
        User user = userRepo.findById(userId).get();
        Permissions permissions = permissionsRepo.findById(permissionId).get();

        permissionsSet = user.getAssignPermissions();
        permissionsSet.add(permissions);

        user.setAssignPermissions(permissionsSet);

        return userRepo.save(user);
    }

    @Override
    public User removePermissionsFromUser(Long userId, Long permissionId) {
        Set<Permissions> permissionSet = null;

        User user = userRepo.findById(userId).get();
        Permissions permissions = permissionsRepo.findById(permissionId).get();

        permissionSet = user.getAssignPermissions();
        permissionSet.remove(permissions);

        user.setAssignPermissions(permissionSet);

        return userRepo.save(user);
    }
}
