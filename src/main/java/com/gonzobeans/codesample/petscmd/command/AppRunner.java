package com.gonzobeans.codesample.petscmd.command;

import com.gonzobeans.codesample.petscmd.model.Pet;
import com.gonzobeans.codesample.petscmd.repository.PetRepository;
import com.gonzobeans.codesample.petscmd.service.CsvInputReader;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AppRunner {
    private CommandLine commandLine;
    private PetRepository petRepository;
    private CsvInputReader csvInputReader;

    public AppRunner(CommandLine commandLine) {
        this.commandLine = commandLine;
        this.petRepository = new PetRepository();
        this.csvInputReader = new CsvInputReader(petRepository);
    }

    public void run() {
        addFileToRepository(Paths.get(commandLine.getOptionValue("f")));

    }

    private void addFileToRepository(Path path) {
        try {
            int startingSize = petRepository.getNumberOfEntries();
            csvInputReader.readFile(path);
            System.out.println(String.format("Added %d entries", petRepository.getNumberOfEntries() - startingSize ));
        } catch (IOException e) {
            System.out.println("Problem reading file");
        }
    }

    private void searchRepository(String searchString) {
        List<Pet> pets = petRepository.searchForPets(searchString);
    }

    private void displayResults() {

    }
}
