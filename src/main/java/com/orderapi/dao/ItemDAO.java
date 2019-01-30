package com.orderapi.dao;

import com.orderapi.dto.ItemCategoryDTO;
import com.orderapi.storedprocedure.CreateItemCategorySP;
import com.orderapi.storedprocedure.GetItemCategoriesSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ItemDAO {
    @Autowired
    DataSource dataSource;

    public void createItemCategory(ItemCategoryDTO itemCategoryDTO) {
        CreateItemCategorySP createCounterTypeSP = new CreateItemCategorySP(dataSource);
        createCounterTypeSP.execute(itemCategoryDTO.getName(),itemCategoryDTO.getCounterTypeId());
    }

    public List<ItemCategoryDTO> getItemCategoryList() {
        GetItemCategoriesSP getItemCategoriesSP = new GetItemCategoriesSP(dataSource);
        List<ItemCategoryDTO> itemCategoryDTOS = getItemCategoriesSP.execute();
        return itemCategoryDTOS;
    }
}
