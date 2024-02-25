package com.amirul.spring.springbootmysql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amirul.spring.springbootmysql.model.Permissions;

public interface PermissionsRepo extends CrudRepository<Permissions, Long>{
    List<Permissions> findAll();
}
