package com.orderapi.dto;

public class ItemCategoryDTO {
    private int id;
    private String name;
    private String counterType;
    private int counterTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounterType() {
        return counterType;
    }

    public void setCounterType(String counterType) {
        this.counterType = counterType;
    }

    public int getCounterTypeId() {
        return counterTypeId;
    }

    public void setCounterTypeId(int counterTypeId) {
        this.counterTypeId = counterTypeId;
    }
}
