package com.jack;

public class Myparser {
    private Myschema myschema;
    private String[] myArgs;

    public Myparser( Myschema myschema ) {
        this.myschema = myschema;
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
            else if("int".equals(getArgType(myArgs[i])))
                passParse = parseIntFlag(myArgs[i],myArgs[++i]);
            else if("string".equals(getArgType(myArgs[i])))
                passParse = parseStringFlag(myArgs[i],myArgs[++i]);
            else
                passParse = false;
        }

        return passParse;
    }

    private boolean parseStringFlag( String flag, String value ) {
        return true;
    }

    private boolean parseIntFlag( String flag, String value ) {
        return true;
    }

    private boolean parseBooleanFlag( String myArg ) {
        return true;
    }

    private String getArgType( String myArg ) {
        return myschema.getFlagtypeByFlagname(myArg);
    }
}
