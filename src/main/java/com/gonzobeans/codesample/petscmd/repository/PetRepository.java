package com.gonzobeans.codesample.petscmd.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonzobeans.codesample.petscmd.model.Pet;


import java.nio.file.Path;
import java.util.*;


public class PetRepository {

    private HashMap<String, Pet> pets;
    private ObjectMapper mapper;

    public PetRepository() {
        this.pets = new LinkedHashMap<>();
        this.mapper = new ObjectMapper();
    }

    public void readRepository(Path filePath) {
        //Read the repository in from a file in JSON format
    }

    public void saveRepository(Path filePath) {
        //Save the repository to a file in JSON format
    }

    public void AddOrUpdatePet(Pet pet) {
        pets.put(pet.getId(), pet);
    }

    //Performance of this search is Order-N
    //This really should be optional as well
    public List<Pet> searchForPets(String searchString) {
        Map<String, String> searchMap = getSearchMapFromString(searchString);

        List<Pet> searchList = new ArrayList<>();

        for (Pet pet : pets.values()) {
            if (petMatches(pet, searchMap)) {
                searchList.add(new Pet(pet));
            }
        }

        return searchList;
    }


    public Optional<Pet> getPetById(String id) {
        if (pets.containsKey(id)) {
            return Optional.of(new Pet(pets.get(id)));
        }
        return Optional.empty();
    }

    //This function can be refactored out of class... pass the search map into the class.
    Map<String, String> getSearchMapFromString(String searchString) {
        Map<String, String> searchOptions = new HashMap<>();

        List<String> searchPairs = Arrays.asList(searchString.split(","));
        for (String pair : searchPairs) {
            String[] keyValArray = pair.split(":");
            if (keyValArray.length == 2) {
                searchOptions.put(keyValArray[0].toLowerCase(), keyValArray[1]);
            }
        }
        return searchOptions;
    }

    private boolean petMatches(Pet pet, Map<String, String> searchMap) {
        boolean petMatches = true;

        if (searchMap.containsKey("name") && !pet.getName().equalsIgnoreCase(searchMap.get("name"))) {
            petMatches = false;
        }

        if (searchMap.containsKey("type") && !pet.getType().equalsIgnoreCase(searchMap.get("type"))) {
            petMatches = false;
        }

        if (searchMap.containsKey("gender") && !pet.getGender().equalsIgnoreCase(searchMap.get("gender"))) {
            petMatches = false;
        }

        if (searchMap.containsKey("reproduction") && !pet.getReproduction().equalsIgnoreCase(searchMap.get("reproduction"))) {
            petMatches = false;
        }

        if (searchMap.containsKey("zipcode") && !pet.getGender().startsWith(searchMap.get("zipcode"))) {
            petMatches = false;
        }
        return petMatches;
    }
}
