package com.example.petclinic.services;
import com.example.petclinic.model.Vet;


public interface VetService {
    Vet findById (Long id);

    Vet save (Vet vet);

    Set<Vet> findAll ();
}
