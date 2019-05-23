package com.exercise.dto;

import com.exercise.domain.enumeration.Permission;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {

    private Long id;
    private String nombre;
    private String password;
    private List<Permission> permisos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permission> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permission> permisos) {
        this.permisos = permisos;
    }
}
