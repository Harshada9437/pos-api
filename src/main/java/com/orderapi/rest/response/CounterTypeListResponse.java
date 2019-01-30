package com.orderapi.rest.response;

import com.orderapi.dto.CounterTypeDTO;

import java.util.List;

public class CounterTypeListResponse {
    private List<CounterTypeDTO> counterTypes;
    private String messageType;

    public List<CounterTypeDTO> getCounterTypes() {
        return counterTypes;
    }

    public void setCounterTypes(List<CounterTypeDTO> counterTypes) {
        this.counterTypes = counterTypes;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "CounterTypeListResponse{" +
                "counterTypes=" + counterTypes +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
