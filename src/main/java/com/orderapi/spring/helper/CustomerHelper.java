package com.orderapi.spring.helper;

import com.orderapi.spring.bo.counter.CreateCustomerBO;
import com.orderapi.spring.dto.CustomerDTO;
import com.orderapi.spring.rest.request.CreateCustomerRequest;

public class CustomerHelper {
    public static CustomerDTO buildCustomerDTOFromBO(CreateCustomerBO createCustomerBO) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(createCustomerBO.getName());
        customerDTO.setEmail(createCustomerBO.getEmail());
        customerDTO.setPhone(createCustomerBO.getPhone());
        customerDTO.setLocality(createCustomerBO.getLocality());
        customerDTO.setDob(createCustomerBO.getDob());
        customerDTO.setDoa(createCustomerBO.getDoa());
        return customerDTO;
    }

    public static CreateCustomerBO buildCustomerBOFromRequest(CreateCustomerRequest customerRequest) {
        CreateCustomerBO customerBO = new CreateCustomerBO();
        customerBO.setName(customerRequest.getName());
        customerBO.setEmail(customerRequest.getEmail());
        customerBO.setPhone(customerRequest.getPhone());
        customerBO.setLocality(customerRequest.getLocality());
        customerBO.setDob(customerRequest.getDob());
        customerBO.setDoa(customerRequest.getDoa());
        return customerBO;
    }
}
