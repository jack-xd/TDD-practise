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
        for(int i=0;i<commandLines.length;i++)
            commands.put(commandLines[i],commandLines[++i]);
    }

    public String getValue( String flag ) {
        return commands.get(flag);
    }
}
