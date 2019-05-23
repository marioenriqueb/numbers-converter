package com.exercise.domain;

import com.exercise.domain.enumeration.Permission;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mario on 23/05/2019.
 */
@Embeddable
public class PermissionId implements Serializable {

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "PERMISSION")
    private Permission permission;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
