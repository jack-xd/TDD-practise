package com.jack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        marsRover.getCommand("move:l,l,l,l");
        assertEquals("50,55,E",marsRover.getStatus() );
    }

    @Test()
    void should_not_go_beyond_region() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        MarsRover marsRover = new MarsRover();
        marsRover.getCommand("region:100,100;init:50,50,N");
        Assertions.assertThrows(RuntimeException.class,()->{
            marsRover.getCommand("move:f100");
        });
        assertEquals("50,100,N\n", outContent.toString());
    }

    @Test
    void should_abort_following_command_if_something_wrong() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        MarsRover marsRover = new MarsRover();
        marsRover.getCommand("region:100,100;init:50,50,N");
        Assertions.assertThrows(RuntimeException.class,()->{
            marsRover.getCommand("move:f100,b50");
        });
        assertEquals("50,100,N\n", outContent.toString());
    }
}
