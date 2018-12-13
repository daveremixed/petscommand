package com.gonzobeans.codesample.petscmd.service;

import com.gonzobeans.codesample.petscmd.model.Pet;

import java.util.Optional;

public class PetConverter {

    private static final String GENDER_MALE = "male";
    private static final String GENDER_FEMALE = "female";
    private static final String REPRODUCTION_NEUTERED = "neutered";
    private static final String REPRODUCTION_SPAYED = "spayed";

    private static final String ZIPCODE_REGEX = "^\\d{5}(-\\d{4})?$";

    public static Optional<Pet> getPetFromData(String id, String name, String type, String gender, String zipCode) {
        boolean petValid = true;

        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);
        pet.setType(type.toLowerCase());
        switch (gender.toLowerCase()) {

            case "m":
            case "male":
                pet.setGender(GENDER_MALE);
                break;

            case "f":
            case "female":
                pet.setGender(GENDER_FEMALE);
                break;

            case "neutered":
                pet.setGender(GENDER_MALE);
                pet.setReproduction(REPRODUCTION_NEUTERED);
                break;

            case "spayed":
                pet.setGender(GENDER_FEMALE);
                pet.setReproduction(REPRODUCTION_SPAYED);
                break;

            case "default":
                petValid = false;

        }

        if (petValid && validateZip(zipCode)) {
            pet.setZipCode(zipCode);
            return Optional.of(pet);
        }
        return Optional.empty();

    }

    private static boolean validateZip(String zipCode) {
        return zipCode.matches(ZIPCODE_REGEX);
    }
}
