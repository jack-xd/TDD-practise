package com.jack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Schema {
    private final String schemaConfig;
    private Map<String,String> schemas;

    public Schema( String schema ) {
        this.schemaConfig = schema;
        schemas = new HashMap<>();
        Arrays.asList(schema.split(";"))
                .stream()
                .forEach(flag->{
                    String[] nameValue = flag.split(":");
                    schemas.put(nameValue[0],nameValue[1]);
                });
    }

    public Object getValue( String flag, String strValue) {
        if (isNullString(strValue)) return null;

        String type = schemas.get(flag);
        if (isNullString(type)) return null;
        switch (type){
            case "boolean":
                return "true".equalsIgnoreCase(strValue);
            case "int":
                return Integer.parseInt(strValue);
            case "string":
                return strValue;
            case "list":
                return Arrays.asList(strValue.split(","));

        }
        return strValue;
    }

    private boolean isNullString( String strValue ) {
        return (null == strValue) || strValue.length()==0;
    }
}
