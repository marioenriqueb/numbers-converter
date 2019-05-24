package com.exercise.domain;

import com.exercise.domain.enumeration.Permission;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 25/04/2019.
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "id.userName", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserPermission> permisos = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserPermission> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<UserPermission> permisos) {
        this.permisos = permisos;
    }
}
