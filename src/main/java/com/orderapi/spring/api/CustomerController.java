package com.orderapi.spring.api;

import com.orderapi.spring.helper.CustomerHelper;
import com.orderapi.spring.requesthandler.CustomerRequestHandler;
import com.orderapi.spring.rest.request.CreateCustomerRequest;
import com.orderapi.spring.rest.request.UpdateCustomerRequest;
import com.orderapi.spring.rest.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/customers")
@Controller
public class CustomerController {
    @Autowired
    CustomerRequestHandler customerRequestHandler;
    @Autowired
    MessageResponse messageResponse;

    @RequestMapping( value = "/getCustomer/{cust_id}", method = RequestMethod.GET )
    public
    @ResponseBody
     MessageResponse findOne(@PathVariable("cust_id") int id ){
        messageResponse.setMessageType("SUCCESS");
       // messageResponse.setMessage(customerRequestHandler.findName( id ));
        return messageResponse;
    }

    @RequestMapping( value = "/getCustomerList", method = RequestMethod.GET )
    public
    @ResponseBody
    MessageResponse getCustomerList( ){
        messageResponse.setMessageType("SUCCESS");
        //messageResponse.setMessage(customerRequestHandler.getCustomerList( ));
        return messageResponse;
    }

    @RequestMapping( value = "/deleteCustomer/{cust_id}", method = RequestMethod.GET )
    public
    @ResponseBody
    MessageResponse getCustomerList(@PathVariable("cust_id") int id){
       // customerRequestHandler.deleteCustomer(id);
        messageResponse.setMessageType("SUCCESS");
        return messageResponse;
    }

    @RequestMapping( value = "/updateCustomer", method = RequestMethod.POST )
    public
    @ResponseBody
    MessageResponse updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        //customerRequestHandler.updateCustomer(updateCustomerRequest);
        messageResponse.setMessageType("SUCCESS");
        return messageResponse;
    }

    @RequestMapping( value = "/createCustomer", method = RequestMethod.POST )
    public
    @ResponseBody
    MessageResponse createCustomer(@RequestBody CreateCustomerRequest customerRequest){
        //customerRequestHandler.createCustomer(CustomerHelper.buildCustomerBOFromRequest(customerRequest));
        messageResponse.setMessageType("SUCCESS");
        return messageResponse;
    }

}
