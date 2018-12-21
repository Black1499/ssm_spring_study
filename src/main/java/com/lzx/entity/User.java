package com.lzx.entity;

public class User {
    private Integer id;

    private String name;

    private String password;

    private Integer permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(Integer id, String name, String password, Integer permission) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.permission = permission;
    }

    public User(String name) {
        this.name = name;
        this.permission = 4;
    }
}