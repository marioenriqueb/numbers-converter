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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    private User user;

    public UserPermission() {
        this.id = new PermissionId();
    }

    public PermissionId getId() {
        return id;
    }

    public void setId(PermissionId id) {
        this.id = id;
    }

    public Permission getPermission() {
        return id.getPermission();
    }

    public void setPermission(Permission permission) {
        this.id.setPermission(permission);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
