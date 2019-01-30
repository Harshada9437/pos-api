package com.orderapi.helper;

import com.orderapi.bo.ItemCategoryCreateRequestBO;
import com.orderapi.bo.counter.CounterTypeCreateRequestBO;
import com.orderapi.dto.ItemCategoryDTO;
import com.orderapi.rest.request.ItemCategoryCreateRequest;

public class ItemHelper {
    public static ItemCategoryCreateRequestBO buildCategoryCreateRequestBOFromRequest(ItemCategoryCreateRequest itemCategoryCreateRequest) {
        ItemCategoryCreateRequestBO itemCategoryCreateRequestBO = new ItemCategoryCreateRequestBO();
        itemCategoryCreateRequestBO.setCounterTypeId(itemCategoryCreateRequest.getCounterTypeId());
        itemCategoryCreateRequestBO.setName(itemCategoryCreateRequest.getName());
        return itemCategoryCreateRequestBO;
    }

    public static ItemCategoryDTO buildCategoryDTOFromCreateRequest(ItemCategoryCreateRequestBO categoryCreateRequestBO) {
        ItemCategoryDTO itemCategoryDTO = new ItemCategoryDTO();
        itemCategoryDTO.setCounterTypeId(categoryCreateRequestBO.getCounterTypeId());
        itemCategoryDTO.setName(categoryCreateRequestBO.getName());
        return itemCategoryDTO;
    }
}
