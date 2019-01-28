package com.orderapi.spring.rest.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class LoginRequest {
    @NotNull(message = "User name field can't be null.")
    @NotEmpty(message = "User name field can't be empty.")
    private String userName;
    @NotNull(message = "Password field can't be null.")
    @NotEmpty(message = "Password field can't be empty.")
    private String password;

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

    @Override
    public String toString() {
        return "LoginRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
