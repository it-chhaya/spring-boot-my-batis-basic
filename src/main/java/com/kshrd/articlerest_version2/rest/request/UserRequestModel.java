package com.kshrd.articlerest_version2.rest.request;

import java.util.ArrayList;
import java.util.List;

public class UserRequestModel {

    private String username;
    private String password;
    private String confirmPassword;

    private ArrayList<RoleRequestModel> roles;

    public UserRequestModel() {}

    public UserRequestModel(String username,
                            String password,
                            String confirmPassword,
                            ArrayList<RoleRequestModel> roles) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.roles = roles;
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

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public List<RoleRequestModel> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<RoleRequestModel> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRequestModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", roles=" + roles +
                '}';
    }
}
