package com.gonzobeans.codesample.petscmd;

import com.gonzobeans.codesample.petscmd.command.AppOptions;
import com.gonzobeans.codesample.petscmd.command.AppRunner;
import org.apache.commons.cli.*;


public class App
{
    public static void main( String[] args )
    {
        CommandLineParser parser = new DefaultParser();
        Options options = AppOptions.getCommandLineOptions();

        try {
            CommandLine cmd = parser.parse(options, args);
            AppRunner appRunner = new AppRunner(cmd);
            appRunner.run();
        } catch (ParseException e) {
            System.out.println("Invalid Command Line");
        }
    }
}
