package com.orderapi.api;

import com.orderapi.bo.counter.*;
import com.orderapi.constants.CounterConstants;
import com.orderapi.constants.MESSAGETYPE;
import com.orderapi.dto.*;
import com.orderapi.helper.CounterHelper;
import com.orderapi.requesthandler.CounterRequestHandler;
import com.orderapi.rest.request.counter.*;
import com.orderapi.rest.response.CounterListResponse;
import com.orderapi.rest.response.CounterTypeListResponse;
import com.orderapi.rest.response.MessageResponse;
import com.orderapi.util.UserRequestValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("Counter operations")
@RequestMapping(CounterConstants.counter)
@Controller
public class CounterController {
    @Autowired
    private CounterRequestHandler counterRequestHandler;
    @Autowired
    private MessageResponse messageResponse;

    private static final Logger logger = LoggerFactory.getLogger(CounterController.class);

    @ApiOperation(value = "Counter type creation process",
            response = CounterController.class)
    @RequestMapping(value = CounterConstants.counter_type_create, method = RequestMethod.POST)
    public
    @ResponseBody
    MessageResponse createCounterType(@RequestHeader("Auth") String auth, @Valid @RequestBody CounterTypeCreateRequest typeCreateRequest, BindingResult result) {
        if (result.hasErrors()) {
            messageResponse.setMessage(result.getFieldError().getDefaultMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        } else {
            try {
                // if(auth != null && new UserRequestValidation().isRequestValid(auth)) {
                CounterTypeCreateRequestBO typeCreateRequestBO = CounterHelper.buildTypeCreateRequestBOFromRequest(typeCreateRequest);
                counterRequestHandler.createCounterType(typeCreateRequestBO);
                messageResponse.setMessage("New counter type has been created.");
                messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                return messageResponse;
            /*    }else{
                    messageResponse.setMessageType("UNAUTHORIZED");
                    messageResponse.setMessage("UNAUTHORIZED ACCESS");
                    return messageResponse;
                }*/
            } catch (Exception e) {
                e.printStackTrace();
                messageResponse.setMessage(e.getMessage());
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        }
    }

    @ApiOperation(value = "Counter type update process",
            response = CounterController.class)
    @RequestMapping(value = CounterConstants.counter_type_update, method = RequestMethod.POST)
    public
    @ResponseBody
    MessageResponse updateCounterType(@Valid @RequestBody CounterTypeUpdateRequest typeCreateRequest, BindingResult result) {
        if (result.hasErrors()) {
            messageResponse.setMessage(result.getFieldError().getDefaultMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        } else {
            try {
                CounterTypeUpdateRequestBO typeCreateRequestBO = CounterHelper.buildTypeUpdateRequestBOFromRequest(typeCreateRequest);
                counterRequestHandler.updateCounterType(typeCreateRequestBO);
                messageResponse.setMessage("Counter type updated successfully.");
                messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                return messageResponse;
            } catch (Exception e) {
                e.printStackTrace();
                messageResponse.setMessage(e.getMessage());
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        }
    }

    @ApiOperation(value = "Counter update process",
            response = CounterController.class)
    @RequestMapping(value = CounterConstants.counter_update, method = RequestMethod.POST)
    public
    @ResponseBody
    MessageResponse updateCounter(@Valid @RequestBody CounterUpdateRequest typeCreateRequest, BindingResult result) {
        if (result.hasErrors()) {
            messageResponse.setMessage(result.getFieldError().getDefaultMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        } else {
            try {
                CounterUpdateRequestBO counterTypeUpdateRequestBO = CounterHelper.buildUpdateRequestBOFromRequest(typeCreateRequest);
                counterRequestHandler.updateCounter(counterTypeUpdateRequestBO);
                messageResponse.setMessage("Counter type updated successfully.");
                messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                return messageResponse;
            } catch (Exception e) {
                e.printStackTrace();
                messageResponse.setMessage(e.getMessage());
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        }
    }

    @ApiOperation(value = "Counter type list process",
            response = CounterController.class)
    @RequestMapping(value = CounterConstants.get_counter_type_list, method = RequestMethod.GET)
    public
    @ResponseBody
    Object getCounterType() {
        try {
            CounterTypeListResponse counterTypeListResponse = new CounterTypeListResponse();
            List<CounterTypeDTO> counterTypes = counterRequestHandler.getCounterType();
            if (counterTypes.size() > 0) {
                counterTypeListResponse.setCounterTypes(counterTypes);
                counterTypeListResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                return counterTypeListResponse;
            } else {
                messageResponse.setMessage("Failed to create the given counter type");
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageResponse.setMessage(e.getMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        }
    }

    @ApiOperation(value = "Counter list process",
            response = CounterController.class)
    @RequestMapping(value = CounterConstants.get_counter_list, method = RequestMethod.GET)
    public
    @ResponseBody
    Object getCounterList() {
        try {
            CounterListResponse counterListResponse = new CounterListResponse();
            List<CounterDTO> counterTypes = counterRequestHandler.getCounterList();
            if (counterTypes.size() > 0) {
                counterListResponse.setCounters(counterTypes);
                counterListResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                return counterListResponse;
            } else {
                messageResponse.setMessage("Unable to retrieve the list.");
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageResponse.setMessage(e.getMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        }
    }

    @ApiOperation(value = "Counter creation process for  store.",
            response = CounterController.class)
    @RequestMapping(value = CounterConstants.counter_create, method = RequestMethod.POST)
    public
    @ResponseBody
    MessageResponse createCounter(@Valid @RequestBody CounterCreateRequest counterCreateRequest, BindingResult result) {
        if (result.hasErrors()) {
            messageResponse.setMessage(result.getFieldError().getDefaultMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        } else {
            try {
                CounterCreateRequestBO counterCreateRequestBO = CounterHelper.buildCreateRequestBOFromRequest(counterCreateRequest);
                counterRequestHandler.createCounter(counterCreateRequestBO);
                messageResponse.setMessage(String.valueOf(1));
                messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                return messageResponse;
            } catch (Exception e) {
                e.printStackTrace();
                messageResponse.setMessage(e.getMessage());
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        }
    }
}
