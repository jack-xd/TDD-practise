package com.jack;

import java.util.ArrayList;
import java.util.List;

public class Schema {
    List<Flag> flags;

    public Schema( String schemaText ) {
        String[] flagdescs = schemaText.split(";");
        flags = new ArrayList<>();
        for(String desc:flagdescs){
            flags.add(parseFlag(desc));
        }
    }

    private Flag parseFlag( String desc ) {
        Flag flag = new Flag();
        flag.setFlagdesc(desc);
        String[] strs = desc.split(":");
        flag.setFlagname(strs[0]);
        flag.setFlagtype(strs[1]);
        return flag;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public String getFlagDesc( String flagname ) {
        for (Flag flag : flags)
            if(flagname.equals(flag.getFlagname()))
                return flag.getFlagdesc();

        return "";
    }

    public String getFlagType( String flagname ) {
        for (Flag flag : flags)
            if(flagname.equals((flag.getFlagname())))
                return flag.getFlagtype();

        return "";
    }
}
