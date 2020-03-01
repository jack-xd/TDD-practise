package com.jack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchemaTest {
    @Test
    void should_accept_schema_as_text() {
        Schema schema = new Schema("-l:boolean;-p:int;-d:string");
        List<Flag> flags = schema.getFlags();
        assertEquals(3, flags.size());
        assertEquals("-l:boolean", schema.getFlagDesc("-l") );
        assertEquals("boolean", schema.getFlagType("-l") );
        assertEquals("", schema.getFlagDesc("-x") );
    }
}
