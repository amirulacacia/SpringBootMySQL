package com.amirul.spring.springbootmysql.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permissions_id")
    private Long permissionsID;

    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "assignPermissions")
    private Set<User> assignUser = new HashSet<>();

    public Long getPermissionsID() {
        return permissionsID;
    }

    public void setPermissionsID(Long permissionsID) {
        this.permissionsID = permissionsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
