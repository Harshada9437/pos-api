package com.orderapi.spring.rowmapper;

import com.orderapi.spring.dto.CounterTypeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CounterTypeMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        CounterTypeDTO counterTypeDTO = new CounterTypeDTO();
        counterTypeDTO.setId(resultSet.getInt("ID"));
        counterTypeDTO.setName(resultSet.getString("CounterType"));
        return counterTypeDTO;
    }
}