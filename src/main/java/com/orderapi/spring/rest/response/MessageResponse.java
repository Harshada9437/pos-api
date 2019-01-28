package com.orderapi.spring.rest.response;

import org.springframework.stereotype.Component;

@Component
public class MessageResponse {
    private String message;
    private String messageType;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "message='" + message + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
