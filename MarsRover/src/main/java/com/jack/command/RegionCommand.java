package com.jack.command;

import com.jack.RoverState;

public class RegionCommand extends Command {
    @Override
    public String getType() {
        return Command.REGION;
    }

    @Override
    public RoverState updateRoverState( RoverState state, String command ) {
        String[] regions = command.split(",");
        state.setRegionX(Integer.parseInt(regions[0]));
        state.setRegionY(Integer.parseInt(regions[1]));
        return state;
    }
}
