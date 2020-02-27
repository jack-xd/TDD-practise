package com.jack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Myschema {

    List<String> myFlags = new ArrayList<>();
    Map<String,String> myFlagTypeMaps = new HashMap<>();
    Map<String,String> myFlagDescMaps = new HashMap<>();


    public boolean setFlagByFlagname( String flagname ) {
        if(!flagname.startsWith("-"))
            return false;

        myFlags.add(flagname);
        return true;
    }

    public boolean isFlagExist( String flagname ) {
        return myFlags.contains(flagname);
    }

    public boolean setFlagTypeByFlagname( String flagname, String flagtype ) {
        if(!isFlagExist(flagname))
            return false;

        myFlagTypeMaps.put(flagname,flagtype);
        return true;
    }

    public String getFlagtypeByFlagname( String flagname ) {
        return myFlagTypeMaps.get(flagname);
    }

    public String getFlagdescByFlagname( String flagname ) {
        return myFlagDescMaps.get(flagname);
    }

    public boolean setFlagDescByFlagname( String flagname, String flagdesc ) {
        if(!isFlagExist(flagname))
            return false;

        myFlagDescMaps.put(flagname,flagdesc);
        return true;
    }
}
