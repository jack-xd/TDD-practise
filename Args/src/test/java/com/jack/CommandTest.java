package com.jack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {
    @Test
    void should_get_proper_value() {
        Command command = new Command("-l true -p 123");
        assertEquals("true", command.getValue("-l"));
        assertEquals("123", command.getValue("-p"));
        assertEquals("", command.getValue("-x"));

    }

}
