package com.orderapi.storedprocedure.counter;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;

public class UpdateCounterSP extends StoredProcedure {
    private static final String SPROC_NAME = "UpdateCounterSP";

    public UpdateCounterSP(DataSource datasource ){
        super( datasource, SPROC_NAME );
        declareParameter( new SqlParameter( "counter_id", Types.INTEGER) ); //declaring sql in parameter to pass input
        declareParameter( new SqlParameter( "counter_name", Types.VARCHAR) ); //declaring sql in parameter to pass input
        declareParameter( new SqlParameter( "store_id", Types.INTEGER) ); //declaring sql in parameter to pass input
        declareParameter( new SqlParameter( "type_id", Types.INTEGER) ); //declaring sql in parameter to pass input
        compile();
    }

    public Object execute(int id,String name,int store,int type){
        Map<String, Object> results = super.execute(id,name,store,type);
        return results.get(0); //reading output of stored procedure using out parameters
    }
}
