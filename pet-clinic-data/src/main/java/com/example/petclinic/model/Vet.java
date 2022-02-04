package com.example.petclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dim@$$ik
 */
public class Vet extends Person{

    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
