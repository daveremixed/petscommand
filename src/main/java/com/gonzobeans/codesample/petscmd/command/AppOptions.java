package com.gonzobeans.codesample.petscmd.command;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class AppOptions {

    public static Options getCommandLineOptions() {
        Options options = new Options();

        Option file = Option.builder("f")
                .longOpt("file")
                .desc("The path to the CSV data file").build();

        Option search = Option.builder("s")
                .longOpt("search")
                .desc("The search string to execute").build();

        options.addOption(file);
        options.addOption(search);

        return options;
    }

}
