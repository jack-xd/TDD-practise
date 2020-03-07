package com.jack;

import java.util.Arrays;

public class MarsRover {
    private int RegionX;
    private int RegionY;
    private int myX;
    private int myY;
    private String myDirection;
    private int myDegree;

    public void getCommand( String command ) {
        Arrays.asList(command.split(";"))
                .stream()
                .forEach(comm -> {
                    String[] flag = comm.split(":");
                    switch (flag[0]) {
                        case "region":
                            setRegion(flag[1]);
                            break;
                        case "init":
                            setPosition(flag[1]);
                            break;
                        case "move":
                            updatePosition(flag[1]);
                            break;
                        default:
                            // do nothing
                    }
                });
    }

    private void updatePosition( String moveString ) {
        Arrays.asList(moveString.split(","))
                .stream()
                .forEach(moveCommand -> {
                    char command = moveCommand.charAt(0);
                    switch (command) {
                        default:
                            //do nothing
                        case 'f':
                            goForward(moveCommand.substring(1));
                            break;
                        case 'b':
                            goBackward(moveCommand.substring(1));
                            break;
                        case 'l':
                            updateDegree(-90);
                            break;
                        case 'r':
                            updateDegree(+90);
                            break;
                    }
                });
    }

    private void updateDegree( int degree ) {
        this.myDegree += degree;
        updateDirection();
    }

    private void updateDirection() {
        this.myDegree %= 360;
        switch (myDegree) {
            case 0:
                this.myDirection = "N";
                break;
            case -90:
            case 270:
                this.myDirection = "W";
                break;
            case 90:
            case -270:
                this.myDirection = "E";
                break;
            case 180:
            case -180:
                this.myDirection = "S";
                break;
        }

    }


    private void goBackward( String move ) {
        goForward("-" + move);
    }

    private void goForward( String move ) {
        int step = Integer.parseInt(move);
        switch (myDirection) {
            default:
                // do nothing
            case "N":
                this.myY += step;
                break;
            case "S":
                this.myY -= step;
                break;
            case "W":
                this.myX -= step;
                break;
            case "E":
                this.myX += step;
                break;
        }

    }

    private void setPosition( String positionString ) {
        String[] inits = positionString.split(",");
        this.myX = Integer.parseInt(inits[0]);
        this.myY = Integer.parseInt(inits[1]);
        this.myDirection = inits[2];
        this.myDegree = setDegree(inits[2]);
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

    private void setRegion( String regionString ) {
        String[] regions = regionString.split(",");
        this.RegionX = Integer.parseInt(regions[0]);
        this.RegionY = Integer.parseInt(regions[1]);
    }

    public String getStatus() {
        return myX + "," + myY + "," + myDirection;
    }
}
