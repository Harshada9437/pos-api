package com.orderapi.spring.helper;

import com.orderapi.spring.bo.LoginRequestBO;
import com.orderapi.spring.rest.request.LoginRequest;

public class UserHelper {
    public static LoginRequestBO buildLoginRequestBOFromRequest(LoginRequest loginRequest) {
        LoginRequestBO loginRequestBO = new LoginRequestBO();
        loginRequestBO.setPassword(loginRequest.getPassword());
        loginRequestBO.setUserName(loginRequest.getUserName());
        return loginRequestBO;
    }
}
