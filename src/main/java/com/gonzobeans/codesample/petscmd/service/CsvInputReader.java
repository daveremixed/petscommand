package com.gonzobeans.codesample.petscmd.service;

import com.gonzobeans.codesample.petscmd.repository.PetRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class CsvInputReader {

    private PetRepository petRepository;

    public CsvInputReader(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void readFile(Path filePath) throws IOException {

        // try-with-resource pattern will auto close resources
        try (Reader reader = Files.newBufferedReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            csvParser.getRecords().stream()
                    .map(record -> PetConverter.getPetFromData(record.get(0), record.get(1), record.get(2), record.get(3), record.get(4)))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .forEach(pet -> petRepository.AddOrUpdatePet(pet));
        }
    }
}
