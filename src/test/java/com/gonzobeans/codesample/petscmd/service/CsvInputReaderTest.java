package com.gonzobeans.codesample.petscmd.service;

import com.gonzobeans.codesample.petscmd.model.Pet;
import com.gonzobeans.codesample.petscmd.repository.PetRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

public class CsvInputReaderTest {
    private PetRepository petRepository;
    private CsvInputReader csvInputReader;

    @Before
    public void setup() {
        this.petRepository = new PetRepository();
        this.csvInputReader = new CsvInputReader(petRepository);
    }

    @Test
    public void fileLoadTest() throws Exception {
        csvInputReader.readFile(Paths.get("sampledata.csv"));
        Pet pet = petRepository.getPetById("7").get();
        Assert.assertNotNull(pet);
        Assert.assertEquals("Lese", pet.getName());
    }
}
