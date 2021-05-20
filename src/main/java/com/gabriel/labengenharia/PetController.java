package com.gabriel.labengenharia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    PetRepository repository;

    @GetMapping(value = "/pets")
    public List<Pet> allPets() {
        return repository.findAll();
    }

    @PostMapping(value = "/add")
    public String addPet(Pet pet) {
        repository.save(pet);
        return "ok";
    }
}
