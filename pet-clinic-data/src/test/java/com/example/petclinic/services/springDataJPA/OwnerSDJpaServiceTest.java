package com.example.petclinic.services.springDataJPA;

import com.example.petclinic.model.Owner;
import com.example.petclinic.repositories.OwnerRepository;
import com.example.petclinic.repositories.PetRepository;
import com.example.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Jora";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    Owner returnOwner;

    @InjectMocks
    OwnerSDJpaService service;


    @BeforeEach
    void setUp() {
       returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerList = new HashSet<>();
        ownerList.add(Owner.builder().id(1L).build());
        ownerList.add(Owner.builder().id(2L).build());
        ownerList.add(Owner.builder().id(3L).build());


        when(ownerRepository.findAll()).thenReturn(ownerList);

        assertEquals(3, service.findAll().size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);

        assertEquals(owner, returnOwner);
    }

    @Test
    void save() {
        Owner joraToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner joraSaved = service.save(joraToSave);

        assertNotNull(joraSaved);

    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());

    }

    @Test
    void findByLastName() {


        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner jora = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, jora.getLastName());
    }
}