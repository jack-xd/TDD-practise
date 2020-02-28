package com.jack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyparserTest {

    @Test
    void should_create_parser_with_schema() {
        new Myparser(new Myschema());
    }

    private Myschema testSchema;
    private Myparser testparser;

    @ParameterizedTest(name = "should parse pass {0} ")
    @DisplayName("Parse pass Suite")
    @CsvSource({
        "''",
        "'-l'",
        "'-p 8080'",
        "'-d /usr/logs'",
        "'-l -p 8080 -d /usr/logs'",
    })
    void ptestPass(String args){
        initTestSchema();
        testparser = new Myparser(testSchema);
        Assertions.assertTrue(testparser.parse(args));
    }

    @ParameterizedTest(name = "should parse fail {0} ")
    @DisplayName("Parse fail Suite")
    @CsvSource({
        "'-x'",
        "'-p'",
        "'-p 99 90'",
    })
    void ptestFail(String args){
        initTestSchema();
        testparser = new Myparser(testSchema);
        Assertions.assertFalse(testparser.parse(args));
    }

    @ParameterizedTest(name = "should get agrs default value")
    @DisplayName("Test default value get Suite")
    @CsvSource({
        "'-l','false'",
        "'-p','0'",
        "'-d',''",
    })
    void ptest(String flagname, String defaultValue){
        initTestSchema();
        testparser = new Myparser(testSchema);
        assertEquals(defaultValue, testparser.getFlagValue(flagname));
    }

    @ParameterizedTest(name = "should get user specific value")
    @DisplayName("Test user specific Suite")
    @CsvSource({
        "'-l','-l','true'",
        "'-p 10','-p','10'",
        "'-d /root','-d','/root'",
    })
    void ptest(String args, String flagname, String expectvalue){
        initTestSchema();
        testparser = new Myparser(testSchema);
        testparser.parse(args);
        assertEquals(expectvalue,testparser.getFlagValue(flagname) );
    }

    private void initTestSchema() {
        testSchema = new Myschema();
        addOneFlagInSchema("-l", "boolean", "logging，是否记录日志");
        addOneFlagInSchema("-p", "int", "port，端口号");
        addOneFlagInSchema("-d", "string", "directory，目录");

    }

    private void addOneFlagInSchema( String s, String s2, String s3 ) {
        testSchema.setFlagByFlagname(s);
        testSchema.setFlagTypeByFlagname(s, s2);
        testSchema.setFlagDescByFlagname(s, s3);
    }
}
