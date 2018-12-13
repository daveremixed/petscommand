package com.gonzobeans.codesample.petscmd;

import com.gonzobeans.codesample.petscmd.command.AppCommand;
import com.gonzobeans.codesample.petscmd.repository.PetRepository;
import com.gonzobeans.codesample.petscmd.service.CsvInputReader;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import java.io.IOException;
import java.nio.file.Paths;

public class App
{
    public static void main( String[] args )
    {
        AppCommand appCommand = new AppCommand();
        PetRepository petRepository = new PetRepository();
        CsvInputReader csvInputReader = new CsvInputReader(petRepository);

        CommandLine cmd;
        try {
            cmd = appCommand.parseCommandLine(args);
            csvInputReader.readFile(Paths.get(cmd.getOptionValue("f")));

        } catch (ParseException e) {
            System.out.println("Invalid Command Line");
        } catch (IOException e) {
            System.out.println("Problem reading file");
        }

    }
}
