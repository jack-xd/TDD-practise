package com.jack;

import java.util.HashMap;
import java.util.Map;

public class Command {

    Map<String,String> commands;

    public Command( String command ) {
        String[] comm = command.split("\\s+");
        commands = new HashMap<>();

        for(int i=0; i<comm.length; i++){
            commands.put(comm[i],comm[++i]);
        }
    }

    public String getValue( String flag ) {
        String value = commands.get(flag);
        return value == null ? "" : value;
    }
}
