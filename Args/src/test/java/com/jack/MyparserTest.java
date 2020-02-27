package com.jack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    void ptest(String args){
        initTestSchema();
        testparser = new Myparser(testSchema);
        Assertions.assertTrue(testparser.parse(args));
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
