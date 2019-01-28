package com.orderapi.spring.dao;

import com.orderapi.spring.dto.UserDto;
import com.orderapi.spring.rowmapper.UserMapper;
import com.orderapi.spring.storedproc.CustomerSP;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource source) {
        this.jdbcTemplate = new JdbcTemplate(source);
    }

    public UserDto getDetail(String userName,String password){
        String SQL = "SELECT * FROM userdetails where UserName=? and Password=?";
        List<UserDto> user = (List<UserDto>) jdbcTemplate.query(SQL, new UserMapper(),userName,password);
        return user.get(0);
    }

    public void updateLogInSessionId(int id, String sessionId) {
        String SQL = "UPDATE userdetails SET SessionID = ? WHERE ID = ?";
        jdbcTemplate.update(SQL, sessionId, id);
    }
}
