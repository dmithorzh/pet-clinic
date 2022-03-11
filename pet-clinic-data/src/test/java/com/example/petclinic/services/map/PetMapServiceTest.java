package com.example.petclinic.services.map;

import com.example.petclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;

    Pet abobus = Pet.builder().build();
    Pet avtobus = Pet.builder().build();
    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();

        petMapService.save(abobus);
        petMapService.save(avtobus);
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();

        assertEquals(2, petSet.size());
    }

    @Test
    void findByExistingId() {
        Pet pet = petMapService.findById(1L);

        assertEquals(1L, pet.getId());

    }

    @Test
    void findByNonExistingId() {
        Pet pet = petMapService.findById(3L);

        assertNull(pet);

    }

    @Test
    void findByNullId() {
        Pet pet = petMapService.findById(null);

        assertNull(pet);

    }


    @Test
    void save() {
        Pet cocodrillo = Pet.builder().build();
        petMapService.save(cocodrillo);

        assertEquals(3, petMapService.findAll().size());
        assertTrue(petMapService.findAll().contains(cocodrillo));
    }

    @Test
    void saveWithDuplicateId() {
        Long id = 1L;

        Pet sus = Pet.builder().id(id).build();
        petMapService.save(sus);

        assertEquals(2, petMapService.findAll().size());
        assertTrue(petMapService.findAll().contains(sus));
    }
    @Test
    void saveWithExistingId() {
        Long id = 228L;

        Pet sus = Pet.builder().id(id).build();
        petMapService.save(sus);

        assertEquals(3, petMapService.findAll().size());
        assertEquals(sus, petMapService.findById(228L));
    }


    @Test
    void delete() {
        petMapService.delete(abobus);

        assertEquals(1, petMapService.findAll().size());

        assertFalse(petMapService.findAll().contains(abobus));
    }

    @Test
    void deleteNull() {
        petMapService.delete(null);

        assertEquals(2, petMapService.findAll().size());

    }

    @Test
    void deleteNonExistingPet() {
        Pet nyusha = Pet.builder().build();

        petMapService.delete(nyusha);

        assertEquals(2, petMapService.findAll().size());

    }



    @Test
    void deleteById() {
        petMapService.deleteById(2L);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteByWrongId() {
        petMapService.deleteById(3L);

        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void deleteByNullId() {
        petMapService.deleteById(null);

        assertEquals(2, petMapService.findAll().size());
    }
}