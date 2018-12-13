package com.gonzobeans.codesample.petscmd.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonzobeans.codesample.petscmd.model.Pet;


import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;


public class PetRepository {
    HashMap<String, Pet> pets;
    ObjectMapper mapper;

    public PetRepository() {
        this.pets = new LinkedHashMap<>();
        this.mapper = new ObjectMapper();
    }

    public void readRepository(Path filePath) {

    }

    public void saveRepository(Path filePath) {

    }

    public void AddOrUpdatePet(Pet pet) {
        pets.put(pet.getId(), pet);
    }

    public Optional<Pet> getPetById(String id) {
        if (pets.containsKey(id)) {
            return Optional.of(pets.get(id));
        }
        return Optional.empty();
    }
}
