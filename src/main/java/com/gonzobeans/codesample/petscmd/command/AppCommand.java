package com.gonzobeans.codesample.petscmd.command;

import org.apache.commons.cli.*;

public class AppCommand {
    private final CommandLineParser parser;
    private final Options options;

    public AppCommand() {
        parser = new DefaultParser();
        options = AppOptions.getCommandLineOptions();
    }

    public CommandLine parseCommandLine(String[] args ) throws ParseException {
        return parser.parse(options, args);
    }
}
