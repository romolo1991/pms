package com.test.ssh.domain;

public class User {
    private int userId;
    private String name;
    private String password;
    private char isDelete;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(char isDelete) {
        this.isDelete = isDelete;
    }
}
