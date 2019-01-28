package com.orderapi.spring.dao;

import com.orderapi.spring.bo.counter.CounterTypeUpdateRequestBO;
import com.orderapi.spring.dto.CounterDTO;
import com.orderapi.spring.dto.CounterTypeDTO;
import com.orderapi.spring.rowmapper.CounterTypeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CounterDAO {
    private static  JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource source) {
        this.jdbcTemplate = new JdbcTemplate(source);
    }

    public int createCounterType(CounterTypeDTO counterTypeDTO) {
        String query = "INSERT INTO countertype (CounterType) values(?)";
        return jdbcTemplate.update(query,counterTypeDTO.getName());
    }

    public int createCounter(CounterDTO counterDTO) {
        String query = "INSERT INTO counter (Name,StoreID,CounterTypeId) values(?,?,?)";
        return jdbcTemplate.update(query,counterDTO.getName(),counterDTO.getStoreId(),counterDTO.getTypeId());
    }

    public List<CounterTypeDTO> getCounterType() {
        String query = "SELECT * FROM countertype";
        return (List<CounterTypeDTO>)jdbcTemplate.query(query,new CounterTypeMapper());
    }

    public int updateCounterType(CounterTypeUpdateRequestBO typeUpdateRequestBO) {
        String query = "UPDATE countertype SET CounterType=? WHERE ID=?)";
        return jdbcTemplate.update(query,typeUpdateRequestBO.getName(),typeUpdateRequestBO.getId());
    }
}
