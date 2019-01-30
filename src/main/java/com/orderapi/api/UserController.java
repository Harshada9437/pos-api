package com.orderapi.api;

import com.orderapi.bo.LoginRequestBO;
import com.orderapi.constants.MESSAGETYPE;
import com.orderapi.constants.UserConstants;
import com.orderapi.helper.UserHelper;
import com.orderapi.requesthandler.UserRequestHandler;
import com.orderapi.rest.request.LoginRequest;
import com.orderapi.rest.response.LoginResponse;
import com.orderapi.rest.response.MessageResponse;
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

@RequestMapping(UserConstants.user)
@Controller
public class UserController {
    @Autowired
    private UserRequestHandler userRequestHandler;
    @Autowired
    private MessageResponse messageResponse;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "User login process",
            notes = "Inactive user will not be able to log in.",
            response = UserController.class,
            responseContainer = "login")
    @RequestMapping(value = UserConstants.user_login, method = RequestMethod.POST)
    public
    @ResponseBody
    MessageResponse login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        if (result.hasErrors()) {
            messageResponse.setMessage(result.getFieldError().getDefaultMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        } else {
            try {
                LoginRequestBO loginRequestBO = UserHelper.buildLoginRequestBOFromRequest(loginRequest);
                LoginResponse loginResponse = userRequestHandler.login(loginRequestBO);
                if (loginResponse.getSessionKey() != null && loginResponse.getStatus().equals("A")) {
                    messageResponse.setMessage(loginResponse.getSessionKey());
                    messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                    return messageResponse;
                } else {
                    messageResponse.setMessage("Invalid credentials or Inactive user.");
                    messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                    return messageResponse;
                }
            } catch (Exception e) {
                e.printStackTrace();
                messageResponse.setMessage("Something went wrong.");
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        }
    }
}
