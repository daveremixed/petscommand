package com.gonzobeans.codesample.petscmd.model;

public class Pet {
    String id;
    String name;
    String type;
    String gender;
    String zipCode;
    String reproduction;

    public Pet() {

    }

    // Copy Constructor
    public Pet(Pet pet) {
        this.id = pet.id;
        this.name = pet.name;
        this.type = pet.type;
        this.gender = pet.gender;
        this.zipCode = pet.zipCode;
        this.reproduction = pet.reproduction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getReproduction() {
        return reproduction;
    }

    public void setReproduction(String reproduction) {
        this.reproduction = reproduction;
    }


}
