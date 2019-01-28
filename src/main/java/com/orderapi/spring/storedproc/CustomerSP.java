package com.orderapi.spring.storedproc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;

public class CustomerSP extends StoredProcedure {
    private static final String SPROC_NAME = "getPhone";

    public CustomerSP( DataSource datasource ){
        super( datasource, SPROC_NAME );
        declareParameter( new SqlParameter( "customer_id", Types.INTEGER) ); //declaring sql in parameter to pass input

        declareParameter( new SqlOutParameter( "customer_phone", Types.VARCHAR ) ); //declaring sql out parameter
        compile();
    }

    public Object execute(int id){
        Map<String, Object> results = super.execute(id);
        ArrayList arrayList = (ArrayList)results.get("#result-set-1");
        Map<String,String> hash = (Map)arrayList.get(0);
        return hash.get("phone_no"); //reading output of stored procedure using out parameters
    }
}
