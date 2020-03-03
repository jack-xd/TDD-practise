package com.jack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchemaTest {
    @Test
    void test_boolean() {
        Schema schema = new Schema("-l:boolean");
        assertEquals(Boolean.TRUE, schema.getValue("-l","true"));
        assertEquals(Boolean.FALSE,schema.getValue("-l","false"));
        assertEquals(Boolean.FALSE,schema.getValue("-l",null));
    }

    @Test
    void test_int() {
        Schema schema = new Schema("-p:int");
        assertEquals(new Integer(1),schema.getValue("-p","1") );
    }

    @Test
    void test_string() {
        Schema schema = new Schema("-d:string");
        assertEquals("hello",schema.getValue("-d","hello") );
    }
}
