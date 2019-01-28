package com.orderapi.spring.requesthandler;

import com.orderapi.spring.JWTUtil;
import com.orderapi.spring.bo.LoginRequestBO;
import com.orderapi.spring.dao.UserDAO;
import com.orderapi.spring.dto.UserDto;
import com.orderapi.spring.rest.response.LoginResponse;
import com.orderapi.spring.util.MD5Encode;
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
