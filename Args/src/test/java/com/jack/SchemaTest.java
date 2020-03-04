package com.jack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchemaTest {
    @Test
    void test_boolean() {
        Schema schema = new Schema("-l:boolean");
        assertEquals(Boolean.TRUE, schema.getValue("-l","true"));
        assertEquals(Boolean.FALSE,schema.getValue("-l","false"));
        assertEquals(null,schema.getValue("-l",null));
    }

    @Test
    void test_int() {
        Schema schema = new Schema("-p:int");
        assertEquals(new Integer(1),schema.getValue("-p","1") );
        assertEquals(null,schema.getValue("-p",null) );
    }

    @Test
    void test_string() {
        Schema schema = new Schema("-d:string");
        assertEquals("hello",schema.getValue("-d","hello") );
        assertEquals(null,schema.getValue("-d",null) );
    }

    @Test
    void test_not_exist_flag() {
        Schema schema = new Schema("-d:string");
        assertEquals(null, schema.getValue("-x","123"));
        assertEquals(null, schema.getValue("-x",null));
    }

    @Test
    void test_list() {
        Schema schema = new Schema("-l:list");
        List<String> expectedList = Arrays.asList(new String[] {"a","b","c"});
        assertEquals(expectedList, schema.getValue("-l","a,b,c") );
    }
}
