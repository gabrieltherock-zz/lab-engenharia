package com.gabriel.labengenharia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PetMock {

    @Autowired
    PetRepository repository;

    @PostConstruct
    public void adicionaPets() {
        Pet pet1 = new Pet("Rex","cachorro","dobberman");
        Pet pet2 = new Pet("Juliao","cachorro","xiuauaua");
        Pet pet3 = new Pet("Topper","cachorro","dalmata");

        repository.save(pet1);
        repository.save(pet2);
        repository.save(pet3);
    }
}
