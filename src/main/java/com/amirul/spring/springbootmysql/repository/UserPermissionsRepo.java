package com.amirul.spring.springbootmysql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amirul.spring.springbootmysql.model.UserPermissions;

public interface UserPermissionsRepo extends CrudRepository<UserPermissions, Long>{
    List<UserPermissions> findAll();
}
