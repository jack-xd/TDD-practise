package com.jack;

public class UnknownCommand extends Command {
    @Override
    protected RoverState updateRoverState( RoverState state, String command ) {
        // do nothing
        return state;
    }
}
