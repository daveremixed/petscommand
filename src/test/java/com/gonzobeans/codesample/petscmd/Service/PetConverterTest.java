package com.gonzobeans.codesample.petscmd.Service;

import com.gonzobeans.codesample.petscmd.model.Pet;
import com.gonzobeans.codesample.petscmd.service.PetConverter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class PetConverterTest {

    @Test
    public void happyPathTest() {
        Pet pet = PetConverter.getPetFromData("1", "Fluffy", "cat", "female", "97210").get();
        Assert.assertNotNull(pet);
        Assert.assertEquals("Fluffy", pet.getName());
        Assert.assertEquals("female", pet.getGender());
    }

    @Test
    public void spayedTest() {
        Pet pet = PetConverter.getPetFromData("1", "Fluffy", "dog", "spayed", "97210").get();
        Assert.assertNotNull(pet);
        Assert.assertEquals("spayed", pet.getReproduction());
        Assert.assertEquals("Fluffy", pet.getName());
        Assert.assertEquals("female", pet.getGender());
    }

    @Test
    public void neuteredTest() {
        Pet pet = PetConverter.getPetFromData("1", "Fluffster", "dog", "neutered", "97210").get();
        Assert.assertNotNull(pet);
        Assert.assertEquals("male", pet.getGender());
        Assert.assertEquals("Fluffster", pet.getName());
        Assert.assertEquals("neutered", pet.getReproduction());
    }

    @Test
    public void badZip() {
        Optional<Pet> optional = PetConverter.getPetFromData("1", "Fluffy", "cat", "female", "7897210");
        Assert.assertFalse(optional.isPresent());
    }
}
