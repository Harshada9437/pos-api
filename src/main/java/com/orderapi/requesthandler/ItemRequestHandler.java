package com.orderapi.requesthandler;

import com.orderapi.bo.ItemCategoryCreateRequestBO;
import com.orderapi.dao.ItemDAO;
import com.orderapi.dto.ItemCategoryDTO;
import com.orderapi.helper.ItemHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemRequestHandler {
    @Autowired
    ItemDAO itemDAO;

    public void createItemCategory(ItemCategoryCreateRequestBO typeCreateRequestBO) {
        itemDAO.createItemCategory(ItemHelper.buildCategoryDTOFromCreateRequest(typeCreateRequestBO));
    }

    public List<ItemCategoryDTO> getItemCategoryList() {
        return itemDAO.getItemCategoryList();
    }
}
