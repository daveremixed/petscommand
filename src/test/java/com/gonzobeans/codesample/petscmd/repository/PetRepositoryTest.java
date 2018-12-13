package com.gonzobeans.codesample.petscmd.repository;

import com.gonzobeans.codesample.petscmd.model.Pet;
import com.gonzobeans.codesample.petscmd.service.CsvInputReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

public class PetRepositoryTest {

    private PetRepository petRepository;
    private CsvInputReader csvInputReader;

    @Before
    public void setup() throws Exception{
        this.petRepository = new PetRepository();
        this.csvInputReader = new CsvInputReader(petRepository);
        csvInputReader.readFile(Paths.get("sampledata.csv"));
    }

    @Test
    public void dogSearch() {
       List<Pet> pets =  petRepository.searchForPets("type:dog");
        Assert.assertEquals(4, pets.size());
    }

    @Test
    public void dogZipSearch() {
        List<Pet> pets =  petRepository.searchForPets("type:dog,zipcode:90210");
        Assert.assertEquals(2, pets.size());
    }
}
