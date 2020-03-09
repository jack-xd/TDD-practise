package com.jack.command;

import com.jack.RoverState;

public abstract class Command {

    private String type;

    static final String INIT = "init";
    static final String REGION = "region";
    static final String MOVE = "move";

    static public Command createCommand(String name){
        if (INIT.equals(name)) return new InitCommand();
        if (REGION.equals(name)) return new RegionCommand();
        if (MOVE.equals(name)) return new MoveCommand();
        return new UnknownCommand();
    }

    public abstract RoverState updateRoverState( RoverState state, String command);


    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }
}
