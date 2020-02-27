package com.jack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyschemaTest {

    private Myschema myschema = null;

    private String initSchema() {
        myschema = new Myschema();
        String flagname = "-l";
        String flagtype = "boolean";
        String flagdesc = "logging，是否记录日志";
        myschema.setFlagByFlagname(flagname);
        myschema.setFlagTypeByFlagname(flagname,flagtype);
        myschema.setFlagDescByFlagname(flagname,flagdesc);
        return flagname;
    }

    @Test
    void should_set_flag_by_flagname() {
        String flagname = initSchema();
        assertEquals(true, myschema.isFlagExist(flagname));
    }

    @Test
    void shoud_get_flagtype_by_flagname() {
        String flagname = initSchema();
        assertEquals("boolean", myschema.getFlagtypeByFlagname(flagname));
    }

    @Test
    void should_get_flagdesc_by_flagname() {
        String flagname = initSchema();
        Assertions.assertFalse(myschema.getFlagdescByFlagname(flagname).isEmpty());
    }

    @ParameterizedTest(name = "should accept {0} type flag")
    @DisplayName("Acceptable flagtype")
    @CsvSource({
        "'-l','boolean'",
        "'-p','int'",
        "'-d','string'",
    })
    void ptest(String flagname, String flagtype){
        initSchema(flagname,flagtype);
        assertEquals(flagtype, myschema.getFlagtypeByFlagname(flagname));
    }

    private String initSchema(String flagname,String flagtype) {
        myschema = new Myschema();
        myschema.setFlagByFlagname(flagname);
        myschema.setFlagTypeByFlagname(flagname,flagtype);
        return flagname;
    }
}
