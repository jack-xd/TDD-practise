package com.jack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Schema {

    Map<String, String> schemas;

    public Schema( String schema ) {
        schemas = new HashMap<>();
        Arrays.asList(schema.split(";"))
                .stream()
                .forEach(flags -> {
                    String[] names = flags.split(":");
                    schemas.put(names[0], names[1]);
                });
    }

    public Object getValue( String flag, String givenValue ) {
        if (isEmpty(flag))
            return null;

        String flagType = schemas.get(flag);
        if (isEmpty(flagType))
            return null;
        switch (flagType) {
            case "boolean":
                return Boolean.valueOf(givenValue);
            case "int":
                if (isEmpty(givenValue))
                    return new Integer(8080);
                return Integer.parseInt(givenValue);
            case "string":
                return givenValue;
            case "list":
                return givenValue.split(",");

            default:
                return null;

        }
    }

    private boolean isEmpty( String givenValue ) {
        return (null == givenValue || givenValue.length() == 0);
    }
}
