package com.orderapi.rest.response;

import com.orderapi.dto.CounterDTO;

import java.util.List;

public class CounterListResponse {
    private List<CounterDTO> counters;
    private String messageType;

    public List<CounterDTO> getCounters() {
        return counters;
    }

    public void setCounters(List<CounterDTO> counters) {
        this.counters = counters;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "CounterListResponse{" +
                "counters=" + counters +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
