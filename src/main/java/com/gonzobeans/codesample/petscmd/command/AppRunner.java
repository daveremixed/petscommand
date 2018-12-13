package com.gonzobeans.codesample.petscmd.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonzobeans.codesample.petscmd.model.Pet;
import com.gonzobeans.codesample.petscmd.repository.PetRepository;
import com.gonzobeans.codesample.petscmd.service.CsvInputReader;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AppRunner {
    private static final String PERSISTENCE_STORE = "petsdb.json";
    private CommandLine commandLine;
    private PetRepository petRepository;
    private CsvInputReader csvInputReader;

    public AppRunner(CommandLine commandLine) {
        this.commandLine = commandLine;
        this.petRepository = new PetRepository();
        this.csvInputReader = new CsvInputReader(petRepository);
    }

    public void run() {
        petRepository.readRepository(Paths.get(PERSISTENCE_STORE));
        addFileToRepository(Paths.get(commandLine.getOptionValue("f")));
        searchRepository(commandLine.getOptionValue("s"));
        petRepository.saveRepository(Paths.get(PERSISTENCE_STORE));
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
        if (pets != null && pets.size() > 0) {
            displayResults(pets);
        } else {
            System.out.println("Search found no results.");
        }
    }

    private void displayResults(List<Pet> pets) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pets));
        } catch (JsonProcessingException e) {
            System.out.println("Error displaying results");
        }
    }
}
