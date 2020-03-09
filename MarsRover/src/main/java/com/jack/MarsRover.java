package com.jack;

import java.util.Arrays;

public class MarsRover {

    private RoverState myState = new RoverState();
    private Command comm;


    public void setCommand( String command ) {
        Arrays.asList(command.split(";"))
                .stream()
                .forEach(comm -> {
                    processCommand(comm);
                });
    }

    private void processCommand( String command ) {
        String[] flag = command.split(":");
        comm = Command.createCommand(flag[0]);
        comm.updateRoverState(myState,flag[1]);

    }

    private void stopNow() {
        System.out.println(this.getStatus());
        throw new RuntimeException();
    }

    public String getStatus() {
        return myState.getState();
    }
}
