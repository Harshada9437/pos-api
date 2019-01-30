package com.orderapi.requesthandler;

import com.orderapi.util.JWTUtil;
import com.orderapi.bo.LoginRequestBO;
import com.orderapi.dao.UserDAO;
import com.orderapi.dto.UserDto;
import com.orderapi.rest.response.LoginResponse;
import com.orderapi.util.MD5Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
public class UserRequestHandler {
    @Autowired
    UserDAO userDAO;

    public LoginResponse login(LoginRequestBO loginRequest) throws NoSuchAlgorithmException {
        LoginResponse loginResponse = new LoginResponse();

        String encodedPass = MD5Encode.Encode(loginRequest.getPassword());
        UserDto userDto = userDAO.getDetail(loginRequest.getUserName(), encodedPass);

        boolean isValidUser = loginRequest.getUserName().equals(userDto.getUserName()) && encodedPass.equals
                (userDto.getPassword());


        if (!isValidUser) {
            loginResponse.setSessionKey(null);
            return loginResponse;
        } else {
            String token = JWTUtil.createJWT(userDto.getUserName()+"::"+userDto.getPassword());
            loginResponse.setSessionKey(token);
            loginResponse.setStatus(userDto.getStatus());
            loginResponse.setId(userDto.getId());
        }
        return loginResponse;
    }
}
