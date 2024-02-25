package com.amirul.spring.springbootmysql.service.service_implementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amirul.spring.springbootmysql.model.User;
import com.amirul.spring.springbootmysql.repository.UserRepo;
import com.amirul.spring.springbootmysql.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

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
        userRepo.deleteById(id);
        return "Delete Successfully";
    }
}
