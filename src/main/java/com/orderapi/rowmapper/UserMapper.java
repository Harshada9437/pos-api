package com.orderapi.rowmapper;

import com.orderapi.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setId(rs.getInt("ID"));
        userDto.setName(rs.getString("Name"));
        userDto.setEmail(rs.getString("Email"));
        userDto.setSessionId(rs.getString("SessionID"));
        userDto.setPassword(rs.getString("Password"));
        userDto.setStatus(rs.getString("Status"));
        userDto.setUserName(rs.getString("UserName"));
        return userDto;
    }
}
