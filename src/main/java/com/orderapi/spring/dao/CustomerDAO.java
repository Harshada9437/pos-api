package com.orderapi.spring.dao;

import javax.sql.DataSource;

import com.orderapi.spring.dto.CustomerDTO;
import com.orderapi.spring.rowmapper.CustomerMapper;
import com.orderapi.spring.storedproc.CustomerSP;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAO {
    private JdbcTemplate jdbcTemplate;
    private CustomerSP sproc;

    public void setDataSource(DataSource source) {
        this.jdbcTemplate = new JdbcTemplate(source);
        this.sproc = new CustomerSP(jdbcTemplate.getDataSource());
    }
    
    public String getCustomerById(int id) {
        return (String) sproc.execute(id);
    }
    
    public List<CustomerDTO> listCustomers() {
        String SQL = "SELECT * FROM customer where id<10";
        List<CustomerDTO> customers = (List<CustomerDTO>) jdbcTemplate.query(SQL, new CustomerMapper());
        return customers;
    }

    public void delete(Integer id) {
        String SQL = "DELETE FROM customer WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    public void update(Integer id, String email) {
        String SQL = "UPDATE customer SET email_id = ? WHERE id = ?";
        jdbcTemplate.update(SQL, email, id);
    }
    public void create(CustomerDTO customerDTO) {
        String SQL = "INSERT INTO customer (`name`, `phone_no`, `dob`, `doa`, `email_id`, `locality`) VALUES (?,?,?,?,?,?);";
        jdbcTemplate.update(SQL, customerDTO);
    }

}

