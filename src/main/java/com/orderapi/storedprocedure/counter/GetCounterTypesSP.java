package com.orderapi.storedprocedure.counter;

import com.orderapi.dto.CounterTypeDTO;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetCounterTypesSP extends StoredProcedure {
    private static final String SPROC_NAME = "GetCounterTypesSP";

    public GetCounterTypesSP( DataSource datasource ){
        super( datasource, SPROC_NAME );
        compile();
    }

    public List<CounterTypeDTO> execute(){
        Map<String, Object> results = super.execute();
        ArrayList arrayList = (ArrayList)results.get("#result-set-1");
        List<CounterTypeDTO> counterTypeDTOS = new ArrayList<>();
        for(int i=0;i<arrayList.size();i++){
            Map<String,Object>  objectMap = (Map<String, Object>) arrayList.get(i);
            CounterTypeDTO counterTypeDTO = new CounterTypeDTO();
            counterTypeDTO.setName((String) objectMap.get("CounterType"));
            counterTypeDTO.setId((Integer) objectMap.get("ID"));
            counterTypeDTOS.add(counterTypeDTO);
        }
        return counterTypeDTOS; //reading output of stored procedure using out parameters
    }
}
