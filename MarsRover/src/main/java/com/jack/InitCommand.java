package com.jack;

public class InitCommand extends Command {

    @Override
    public String getType() {
        return Command.INIT;
    }

    @Override
    protected RoverState updateRoverState( RoverState state, String command ) {
        String[] inits = command.split(",");

        state.setMyDirection(inits[2]);
        state.setMyDegree(setDegree(inits[2]));
        try {
            state.setMyX(Integer.parseInt(inits[0]));
            state.setMyY(Integer.parseInt(inits[1]));
        } catch (WrongCommandException e) {
            throw new RuntimeException();
        }


        return state;
    }

    private int setDegree( String direction ) {
        switch (direction) {
            default:
                return 0;
            case "N":
                return 0;
            case "E":
                return 90;
            case "S":
                return 180;
            case "W":
                return 270;
        }
    }
}
