package com.orderapi.storedprocedure.counter;

import com.orderapi.dto.CounterDTO;
import com.orderapi.dto.CounterTypeDTO;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetCountersSP extends StoredProcedure {
    private static final String SPROC_NAME = "GetCountersSP";

    public GetCountersSP(DataSource datasource ){
        super( datasource, SPROC_NAME );
        compile();
    }

    public List<CounterDTO> execute(){
        Map<String, Object> results = super.execute();
        ArrayList arrayList = (ArrayList)results.get("#result-set-1");
        List<CounterDTO> counterTypeDTOS = new ArrayList<>();
        for(int i=0;i<arrayList.size();i++){
            Map<String,Object>  objectMap = (Map<String, Object>) arrayList.get(i);
            CounterDTO counterDTO = new CounterDTO();
            counterDTO.setName((String) objectMap.get("Name"));
            counterDTO.setId((Integer) objectMap.get("ID"));
            counterDTO.setStoreId((Integer) objectMap.get("StoreID"));
            counterDTO.setStoreName((String) objectMap.get("store_name"));
            counterDTO.setTypeId((Integer) objectMap.get("CounterTypeId"));
            counterDTO.setTypeName((String) objectMap.get("CounterType"));
            counterTypeDTOS.add(counterDTO);
        }
        return counterTypeDTOS; //reading output of stored procedure using out parameters
    }
}
