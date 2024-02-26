package com.amirul.spring.springbootmysql.service.service_implementation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amirul.spring.springbootmysql.model.Permissions;
import com.amirul.spring.springbootmysql.repository.PermissionsRepo;
import com.amirul.spring.springbootmysql.service.PermissionsService;

@Service
@Transactional
public class PermissionsServiceImpl implements PermissionsService{
    @Autowired
    PermissionsRepo permissionsRepo;

    @Override
    public List<Permissions> findAll() {
        return permissionsRepo.findAll();
    }

    @Override
    public Permissions findById(Long id) {
        return permissionsRepo.findById(id).get();
    }

    @Override
    public Permissions save(Permissions permissions) {
        return permissionsRepo.save(permissions);
    }

    @Override
    public Permissions updatePermissions(Permissions permissions, Long id) {
        Permissions permissionsDB = permissionsRepo.findById(id).get();

        if (Objects.nonNull(permissions.getName())) {
            permissionsDB.setName(permissions.getName());
        }

        return permissionsRepo.save(permissionsDB);
    }

    @Override
    public String deletePermissions(Long id) {
        permissionsRepo.findById(id).orElseThrow(() -> new NoSuchElementException("There is no permission of this id to be delete"));

        permissionsRepo.deleteById(id);

        return "Deleted Successfully";
    }
    
}
