package com.jack;

import java.util.Arrays;

public class RoverState {
    private int myX;
    private int myY;
    private int RegionX;
    private int RegionY;
    private String myDirection;

    public String getState(){
        return myX + "," + myY + "," + myDirection;
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

    private void checkMyStatus() throws WrongCommandException {
        boolean something_wrong=false;
        if (this.myX > RegionX){
            this.myX = RegionX;
            something_wrong = true;
        }
        if (this.myX < 0 ){
            this.myX = 0;
            something_wrong = true;
        }
        if (this.myY > RegionY){
            this.myY = RegionY;
            something_wrong = true;
        }
        if (this.myY < 0){
            this.myY = 0;
            something_wrong = true;
        }
        if(something_wrong) throw new WrongCommandException();
    }


    public int getMyX() {
        return myX;
    }

    public int getMyY() {
        return myY;
    }

    public int getMyDegree() {
        return myDegree;
    }

    public String getMyDirection() {
        return myDirection;
    }

    public void setMyX( int myX ) throws WrongCommandException {
        this.myX = myX;
        checkMyStatus();
    }

    public void setMyY( int myY ) throws WrongCommandException {
        this.myY = myY;
        checkMyStatus();
    }

    public void setRegionX( int regionX ) {
        RegionX = regionX;
    }

    public void setRegionY( int regionY ) {
        RegionY = regionY;
    }

    public void setMyDirection( String myDirection ) {
        this.myDirection = myDirection;
    }

    public void setMyDegree( int myDegree ) {
        this.myDegree = myDegree;
        updateDirection();
    }

    private int myDegree;
}
