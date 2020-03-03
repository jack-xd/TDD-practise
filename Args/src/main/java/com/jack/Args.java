package com.jack;

public class Args {
    private final Command argsCommand;
    private final Schema argsSchema;

    public Args( String schema, String command ) {
        argsSchema = new Schema(schema);
        argsCommand = new Command(command);
    }

    public Object getValue( String flag ) {
        return argsSchema.getValue(flag,argsCommand.getValue(flag));
    }
}
