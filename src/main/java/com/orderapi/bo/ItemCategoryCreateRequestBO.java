package com.orderapi.bo;

public class ItemCategoryCreateRequestBO {
    private String name;
    private int counterTypeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounterTypeId() {
        return counterTypeId;
    }

    public void setCounterTypeId(int counterTypeId) {
        this.counterTypeId = counterTypeId;
    }

}
