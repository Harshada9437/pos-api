package com.orderapi.dao;

import com.orderapi.dto.CounterDTO;
import com.orderapi.dto.CounterTypeDTO;
import com.orderapi.storedprocedure.counter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CounterDAO {
    @Autowired
    DataSource dataSource;


    public void createCounterType(CounterTypeDTO counterTypeDTO) {
        CreateCounterTypeSP createCounterTypeSP = new CreateCounterTypeSP(dataSource);
        createCounterTypeSP.execute(counterTypeDTO.getName());
    }

    public void createCounter(CounterDTO counterDTO) {
        CreateCounterSP createCounterSP = new CreateCounterSP(dataSource);
        createCounterSP.execute(counterDTO.getName(), counterDTO.getStoreId(), counterDTO.getTypeId());
    }

    public List<CounterTypeDTO> getCounterType() {
        GetCounterTypesSP getCounterTypesSP = new GetCounterTypesSP(dataSource);
        List<CounterTypeDTO> counterTypeDTOS = getCounterTypesSP.execute();
        return counterTypeDTOS;
    }

    public void updateCounterType(CounterTypeDTO counterTypeDTO) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UpdateCounterTypeSP updateCounterTypeSP = new UpdateCounterTypeSP(jdbcTemplate.getDataSource());
        updateCounterTypeSP.execute( counterTypeDTO.getName(),counterTypeDTO.getId());
    }

    public List<CounterDTO> getCounterList() {
        GetCountersSP getCounterTypesSP = new GetCountersSP(dataSource);
        List<CounterDTO> counterDTOS = getCounterTypesSP.execute();
        return counterDTOS;
    }

    public void updateCounter(CounterDTO counterDTO) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UpdateCounterSP updateCounterTypeSP = new UpdateCounterSP(jdbcTemplate.getDataSource());
        updateCounterTypeSP.execute( counterDTO.getId(),counterDTO.getName(),counterDTO.getStoreId(),counterDTO.getTypeId());
    }
}
