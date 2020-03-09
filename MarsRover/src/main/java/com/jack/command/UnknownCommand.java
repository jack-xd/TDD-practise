package com.jack.command;

import com.jack.RoverState;

public class UnknownCommand extends Command {
    @Override
    public RoverState updateRoverState( RoverState state, String command ) {
        // do nothing
        return state;
    }
}
