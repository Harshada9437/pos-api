package com.orderapi.storedprocedure;

import com.orderapi.dto.ItemCategoryDTO;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetItemCategoriesSP extends StoredProcedure {
    private static final String SPROC_NAME = "GetCountersSP";

    public GetItemCategoriesSP(DataSource datasource ){
        super( datasource, SPROC_NAME );
        compile();
    }

    public List<ItemCategoryDTO> execute(){
        Map<String, Object> results = super.execute();
        ArrayList arrayList = (ArrayList)results.get("#result-set-1");
        List<ItemCategoryDTO> counterTypeDTOS = new ArrayList<>();
        for(int i=0;i<arrayList.size();i++){
            Map<String,Object>  objectMap = (Map<String, Object>) arrayList.get(i);
            ItemCategoryDTO counterDTO = new ItemCategoryDTO();
            counterDTO.setName((String) objectMap.get("CategoryName"));
            counterDTO.setId((Integer) objectMap.get("ID"));
            counterDTO.setCounterTypeId((Integer) objectMap.get("CounterTypeId"));
            counterDTO.setCounterType((String) objectMap.get("CounterType"));
            counterTypeDTOS.add(counterDTO);
        }
        return counterTypeDTOS; //reading output of stored procedure using out parameters
    }
}
