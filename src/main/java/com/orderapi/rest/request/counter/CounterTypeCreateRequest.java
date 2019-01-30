package com.orderapi.rest.request.counter;

public class CounterTypeCreateRequest {
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "CounterTypeCreateRequest{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
