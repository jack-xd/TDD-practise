package com.jack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {
    @Test
    void should_get_proper_type_and_value() {
        Args args = new Args("-l:boolean;-p:int;-d:string", "-l true -p 80 -d /root");
        assertEquals(Boolean.TRUE, args.getValue("-l"));
        assertEquals(new Integer(80), args.getValue("-p"));
        assertEquals("/root", args.getValue("-d"));
    }
}
