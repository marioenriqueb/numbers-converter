package com.exercise.domain;

import com.exercise.domain.enumeration.Permission;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mario on 23/05/2019.
 */
@Embeddable
public class PermissionId implements Serializable {

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PERMISSION")
    private Permission permission;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
