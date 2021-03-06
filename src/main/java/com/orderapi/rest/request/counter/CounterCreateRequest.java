package com.orderapi.rest.request.counter;

public class CounterCreateRequest {
    private int storeId;
    private int typeId;
    private String name;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CounterCreateRequest{" +
                "storeId=" + storeId +
                ", typeId=" + typeId +
                ", name='" + name + '\'' +
                '}';
    }
}
