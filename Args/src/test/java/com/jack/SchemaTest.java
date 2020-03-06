package com.jack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchemaTest {
    @Test
    void test_boolean() {
        Schema schema = new Schema("-l:boolean");
        assertEquals(Boolean.FALSE, schema.getValue("-l","false"));
        assertEquals(Boolean.TRUE, schema.getValue("-l","true"));
        assertEquals(Boolean.FALSE, schema.getValue("-l",""));
        assertEquals(Boolean.FALSE, schema.getValue("-l",null));
        assertEquals(null, schema.getValue("-x","123"));
        assertEquals(null, schema.getValue(null,"123"));
    }

    @Test
    void test_int() {
        Schema schema = new Schema("-l:int");
        assertEquals(new Integer(80), schema.getValue("-l","80") );
        assertEquals(new Integer(-80), schema.getValue("-l","-80") );
        assertEquals(new Integer(8080), schema.getValue("-l","") );
        assertEquals(new Integer(8080), schema.getValue("-l",null) );
        assertEquals(null, schema.getValue("-x","abc") );
    }

    @Test
    void test_string() {
        Schema schema = new Schema("-l:string");
        assertEquals("/root", schema.getValue("-l","/root"));
    }

    @Test
    void test_list() {
        Schema schema = new Schema("-l:list");
        String[] values = (String[]) schema.getValue("-l","1,2");
        assertEquals("1" , values[0]);
        assertEquals("2" , values[1]);
        assertEquals(2 , values.length);
    }
}
