package com.jack;

import java.util.HashMap;
import java.util.Map;

public class Myparser {
    private Myschema myschema;
    private String[] myArgs;
    private Map<String,String> flags;

    public Myparser( Myschema myschema ) {

        this.myschema = myschema;
        flags = new HashMap<>();
    }

    public boolean parse( String args ) {
        if(args.isEmpty())
            return true;

        myArgs = args.split(" ");
        return parse();
    }

    private boolean parse() {
        boolean passParse = true;
        for (int i = 0; passParse && i < myArgs.length; i++) {
            if("boolean".equals(getArgType(myArgs[i])))
                passParse = parseBooleanFlag(myArgs[i]);
            else if("int".equals(getArgType(myArgs[i])) && i<myArgs.length-1)
                passParse = parseIntFlag(myArgs[i],myArgs[++i]);
            else if("string".equals(getArgType(myArgs[i])) && i<myArgs.length-1)
                passParse = parseStringFlag(myArgs[i],myArgs[++i]);
            else
                passParse = false;
        }

        return passParse;
    }

    private boolean parseStringFlag( String flag, String value ) {
        flags.put(flag,value);
        return true;
    }

    private boolean parseIntFlag( String flag, String value ) {
        flags.put(flag,value);
        return true;

    }

    private boolean parseBooleanFlag( String myArg ) {

        flags.put(myArg,"true");
        return true;
    }

    private String getArgType( String myArg ) {
        return myschema.getFlagtypeByFlagname(myArg);
    }

    public String getFlagValue( String flagname ) {
        if(isFlagSet(flagname))
            return flags.get(flagname);
        return myschema.getDefaultValueByFlagname(flagname);
    }

    private boolean isFlagSet( String flagname ) {

        return flags.containsKey(flagname);
    }
}
