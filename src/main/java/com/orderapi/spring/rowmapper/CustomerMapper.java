package com.orderapi.spring.rowmapper;

import com.orderapi.spring.dto.CustomerDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(rs.getInt("id"));
        customerDTO.setName(rs.getString("name"));
        customerDTO.setEmail(rs.getString("email_id"));
        customerDTO.setPhone(rs.getString("phone_no"));
        customerDTO.setLocality(rs.getString("locality"));
        customerDTO.setDob(rs.getString("dob"));
        customerDTO.setDoa(rs.getString("doa"));
        return customerDTO;
    }
}
