package com.orderapi.rest.response;

import com.orderapi.dto.ItemCategoryDTO;

import java.util.List;

public class ItemCategoryResponseListResponse {
    private List<ItemCategoryDTO> itemCategoryList;
    private String messageType;

    public List<ItemCategoryDTO> getItemCategoryList() {
        return itemCategoryList;
    }

    public void setItemCategoryList(List<ItemCategoryDTO> itemCategoryList) {
        this.itemCategoryList = itemCategoryList;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
