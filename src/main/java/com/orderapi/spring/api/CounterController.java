package com.orderapi.spring.api;

import com.orderapi.spring.RESTUriConstants.CounterConstants;
import com.orderapi.spring.bo.counter.CounterCreateRequestBO;
import com.orderapi.spring.bo.counter.CounterTypeCreateRequestBO;
import com.orderapi.spring.bo.counter.CounterTypeUpdateRequestBO;
import com.orderapi.spring.constants.MESSAGETYPE;
import com.orderapi.spring.dto.CounterTypeDTO;
import com.orderapi.spring.helper.ConterHelper;
import com.orderapi.spring.requesthandler.CounterRequestHandler;
import com.orderapi.spring.rest.request.CounterTypeUpdateRequest;
import com.orderapi.spring.rest.request.counter.CounterCreateRequest;
import com.orderapi.spring.rest.request.counter.CounterTypeCreateRequest;
import com.orderapi.spring.rest.response.CounterTypeListResponse;
import com.orderapi.spring.rest.response.MessageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    MessageResponse createCounterType(@Valid @RequestBody CounterTypeCreateRequest typeCreateRequest, BindingResult result) {
        if (result.hasErrors()) {
            messageResponse.setMessage(result.getFieldError().getDefaultMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        } else {
            try {
                CounterTypeCreateRequestBO typeCreateRequestBO = ConterHelper.buildTypeCreateRequestBOFromRequest(typeCreateRequest);
                int id = counterRequestHandler.createCounterType(typeCreateRequestBO);
                if (id > 0) {
                    messageResponse.setMessage(String.valueOf(id));
                    messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                    return messageResponse;
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
                CounterTypeUpdateRequestBO typeCreateRequestBO = ConterHelper.buildTypeUpdateRequestBOFromRequest(typeCreateRequest);
                boolean isUpdated = counterRequestHandler.updateCounterType(typeCreateRequestBO);
                if (isUpdated) {
                    messageResponse.setMessage("Counter type updated successfully.");
                    messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                    return messageResponse;
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
    }

    @ApiOperation(value = "Counter type list process",
            response = CounterController.class)
    @RequestMapping(value = CounterConstants.counter_type_list, method = RequestMethod.GET)
    public
    @ResponseBody
    Object getCounterType() {
        try {
            CounterTypeListResponse counterTypeListResponse = new CounterTypeListResponse();
            List< CounterTypeDTO> counterTypes=counterRequestHandler.getCounterType();
            if (counterTypes.size()>0) {
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
                CounterCreateRequestBO counterCreateRequestBO = ConterHelper.buildCreateRequestBOFromRequest(counterCreateRequest);
                int id = counterRequestHandler.createCounter(counterCreateRequestBO);
                if (id > 0) {
                    messageResponse.setMessage(String.valueOf(id));
                    messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                    return messageResponse;
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
    }
}
