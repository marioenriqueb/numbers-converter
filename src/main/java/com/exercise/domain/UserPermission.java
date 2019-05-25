package com.exercise.domain;

import com.exercise.domain.enumeration.Permission;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mario on 25/04/2019.
 */
@Entity
@Table(name = "USER_PERMISSION")
public class UserPermission implements Serializable {

    @EmbeddedId
    private PermissionId id;

    public UserPermission() {
        this.id = new PermissionId();
    }

    public UserPermission(String userName, Permission permission) {
        this.id = new PermissionId();
        this.setUserName(userName);
        this.setPermission(permission);
    }

    public PermissionId getId() {
        return id;
    }

    public void setId(PermissionId id) {
        this.id = id;
    }

    public String getUserName() {
        return id.getUserName();
    }

    public void setUserName(String userName) {
        this.id.setUserName(userName);
    }

    public Permission getPermission() {
        return id.getPermission();
    }

    public void setPermission(Permission permission) {
        this.id.setPermission(permission);
    }
}
