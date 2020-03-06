package com.jack;

public class Args {

    private final Schema mySchema;
    private final Command myCommand;

    public Args( String schema, String command ) {
        mySchema = new Schema(schema);
        myCommand = new Command(command);
    }

    public Object getValue( String flag ) {

        return mySchema.getValue(flag,myCommand.getValue(flag));
    }
}
