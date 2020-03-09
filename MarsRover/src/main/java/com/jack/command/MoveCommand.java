package com.jack.command;

import com.jack.RoverState;
import com.jack.WrongCommandException;

import java.util.Arrays;

public class MoveCommand extends Command {
    @Override
    public String getType() {
        return Command.MOVE;
    }

    @Override
    public RoverState updateRoverState( RoverState state, String command ) {
        Arrays.asList(command.split(","))
                .stream()
                .forEach(moveCommand -> {
                    char comm = moveCommand.charAt(0);
                    try {
                        switch (comm) {
                            default:
                                //do nothing
                            case 'f':
                                goForward(state, moveCommand.substring(1));
                                break;
                            case 'b':
                                goBackward(state, moveCommand.substring(1));
                                break;
                            case 'l':
                                updateDegree(state, -90);
                                break;
                            case 'r':
                                updateDegree(state, +90);
                                break;
                        }
                    }catch (WrongCommandException e){
                        System.out.println(state.getState());
                        throw new RuntimeException();
                    }
                });
        return state;
    }

    private void updateDegree( RoverState state, int degree ) {
        state.setMyDegree(state.getMyDegree() + degree);
    }

    private void goBackward( RoverState state, String move ) throws WrongCommandException {
        goForward(state, "-" + move);
    }

    private void goForward( RoverState state, String move ) throws WrongCommandException {
        int step = Integer.parseInt(move);
        switch (state.getMyDirection()) {
            default:
                // do nothing
            case "N":
                state.setMyY(state.getMyY() + step);
                break;
            case "S":
                state.setMyY(state.getMyY() - step);
                break;
            case "W":
                state.setMyX(state.getMyX() - step);
                break;
            case "E":
                state.setMyX(state.getMyX() + step);
                break;
        }
    }


}
