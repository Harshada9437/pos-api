package com.orderapi.helper;

import com.orderapi.bo.LoginRequestBO;
import com.orderapi.rest.request.LoginRequest;

public class UserHelper {
    public static LoginRequestBO buildLoginRequestBOFromRequest(LoginRequest loginRequest) {
        LoginRequestBO loginRequestBO = new LoginRequestBO();
        loginRequestBO.setPassword(loginRequest.getPassword());
        loginRequestBO.setUserName(loginRequest.getUserName());
        return loginRequestBO;
    }
}
