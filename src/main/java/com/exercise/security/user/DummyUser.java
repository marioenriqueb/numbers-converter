package com.exercise.security.user;

public class DummyUser {
    private Integer id;
    private String username;
    private String password;
    private Boolean rememberMe;
    private String role;

    public DummyUser() {
    }

    public DummyUser(Integer id, String username, String password, Boolean rememberMe, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
