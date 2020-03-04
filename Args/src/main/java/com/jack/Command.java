package com.jack;

import java.util.HashMap;
import java.util.Map;

public class Command {
    private final String commandLine;
    private Map<String,String> commands;

    public Command( String commandLine ) {
        this.commandLine = commandLine;
        commands = new HashMap<>();
        String[] commandLines = commandLine.split("\\s+");
        String flag = null;
        String value = null;
        for(int i=0;i<commandLines.length;i++){
            if (isFlag(commandLines[i]))
                flag = commandLines[i];
            if (i<commandLines.length-1 && !isFlag(commandLines[i+1]))
                value = commandLines[++i];

            commands.put(flag,value);
        }
    }

    private boolean isFlag( String str ) {
        return str.startsWith("-");
    }

    public String getValue( String flag ) {
        return commands.get(flag);
    }
}
