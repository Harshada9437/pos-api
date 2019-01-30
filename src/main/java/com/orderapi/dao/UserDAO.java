package com.orderapi.dao;

import com.orderapi.dto.UserDto;
import com.orderapi.rowmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserDAO {
    @Autowired
    DataSource dataSource;

    public UserDto getDetail(String userName,String password) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String SQL = "SELECT * FROM userdetails where UserName=? and Password=?";
        List<UserDto> user = (List<UserDto>) jdbcTemplate.query(SQL, new UserMapper(),userName,password);
        return user.get(0);
    }

}
