package com.orderapi.spring.requesthandler;

import org.springframework.stereotype.Component;

@Component
public class CustomerRequestHandler {
    /*@Autowired
    CustomerDAO customerDAO;

    public String findName(int id) {
        return customerDAO.getCustomerById(id);
    }


    public String getCustomerList() {
        return customerDAO.listCustomers().toString();
    }

    public String deleteCustomer(int id) {
        customerDAO.delete(id);
        return "SUCCESS";
    }


    public String updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        customerDAO.update(updateCustomerRequest.getId(),updateCustomerRequest.getEmail());
        return "SUCCESS";
    }

    public String createCustomer(CreateCustomerBO createCustomerBO) {
        customerDAO.create(CustomerHelper.buildCustomerDTOFromBO(createCustomerBO));
        return "SUCCESS";
    }*/
}
