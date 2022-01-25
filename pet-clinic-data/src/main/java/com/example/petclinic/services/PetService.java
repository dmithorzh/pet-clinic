package com.example.petclinic.services;

import com.example.petclinic.model.Pet;

import java.util.Set;

/**
 * Created by Jora on 25.01.22.
 */
public interface PetService {
    Pet findById (Long id);

    Pet save (Pet pet);

    Set<Pet> findAll ();
}
