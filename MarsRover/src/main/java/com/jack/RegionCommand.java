package com.jack;

public class RegionCommand extends Command {
    @Override
    public String getType() {
        return Command.REGION;
    }

    @Override
    protected RoverState updateRoverState( RoverState state, String command ) {
        String[] regions = command.split(",");
        state.setRegionX(Integer.parseInt(regions[0]));
        state.setRegionY(Integer.parseInt(regions[1]));
        return state;
    }
}
