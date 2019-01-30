package com.orderapi.storedprocedure.counter;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;

public class UpdateCounterTypeSP extends StoredProcedure {
    private static final String SPROC_NAME = "UpdateCounterTypeSP";

    public UpdateCounterTypeSP(DataSource datasource ){
        super( datasource, SPROC_NAME );
        declareParameter( new SqlParameter( "counter_type", Types.VARCHAR) ); //declaring sql in parameter to pass input
        declareParameter( new SqlParameter( "counter_id", Types.INTEGER) ); //declaring sql in parameter to pass input
        compile();
    }
}
