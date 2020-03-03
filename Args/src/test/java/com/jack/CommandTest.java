package com.jack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {
    @Test
    void test_has_value() {
        Command command = new Command("-l true -p 10 -d /root");
        assertEquals("true", command.getValue("-l"));
        assertEquals("10", command.getValue("-p") );
        assertEquals("/root", command.getValue("-d") );
    }
}
