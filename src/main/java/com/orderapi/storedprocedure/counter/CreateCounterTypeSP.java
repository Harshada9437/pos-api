package com.orderapi.storedprocedure.counter;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;

public class CreateCounterTypeSP extends StoredProcedure {
    private static final String SPROC_NAME = "CreateCounterTypeSP";

    public CreateCounterTypeSP( DataSource datasource ){
        super( datasource, SPROC_NAME );
        declareParameter( new SqlParameter( "counterType", Types.VARCHAR) ); //declaring sql in parameter to pass input
        compile();
    }
}
