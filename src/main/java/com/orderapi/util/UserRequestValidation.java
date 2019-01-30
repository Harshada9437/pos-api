package com.orderapi.util;

import com.orderapi.dao.UserDAO;
import com.orderapi.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by System-3 on 12/7/2016.
 */
public class UserRequestValidation {

    public Boolean isRequestValid(String autherization) throws Exception {
        String decodedString = JWTUtil.getClaim(autherization);
        String[] stringParts = decodedString.split("::");
        Boolean isValidRequest = Boolean.FALSE;
        UserDto userDto = new UserDAO().getDetail(stringParts[0], stringParts[1]);
        if (userDto.getId() != 0) {
            isValidRequest = Boolean.TRUE;
        }

        return isValidRequest;
    }
}
