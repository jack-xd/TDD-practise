package com.jack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void should_accept_command() {
        MarsRover marsRover = new MarsRover();
        marsRover.getCommand("region:100,100;init:50,50,N");
        assertEquals("50,50,N", marsRover.getStatus());
        marsRover.getCommand("move:f10,b5");
        assertEquals("50,55,N", marsRover.getStatus());
        marsRover.getCommand("move:l,r,r");
        assertEquals("50,55,E",marsRover.getStatus() );
        marsRover.getCommand("move:r,r,r,r");
        assertEquals("50,55,E",marsRover.getStatus() );
    }


}
