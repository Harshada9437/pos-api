package com.orderapi.storedprocedure;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;

public class CreateItemCategorySP extends StoredProcedure {
    private static final String SPROC_NAME = "CreateItemCategorySP";

    public CreateItemCategorySP( DataSource datasource ){
        super( datasource, SPROC_NAME );
        declareParameter( new SqlParameter( "category_name", Types.VARCHAR) ); //declaring sql in parameter to pass input
        declareParameter( new SqlParameter( "counter_type_id", Types.INTEGER) ); //declaring sql in parameter to pass input
        compile();
    }
}
