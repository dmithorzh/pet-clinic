package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType lizard= new PetType();
        lizard.setName("Lizard");
        PetType savedLizardPetType = petTypeService.save(lizard);

        PetType abobus = new PetType();
        abobus.setName("Abobus");
        PetType savedAbobusPetType = petTypeService.save(abobus);

        Specialty anesthesiology = new Specialty();
        anesthesiology.setDescription("Anesthesiology");
        Specialty savedAnesthesiology = specialtyService.save(anesthesiology);

        Specialty susology = new Specialty();
        anesthesiology.setDescription("Susology");
        Specialty savedSusology = specialtyService.save(susology);

        Owner owner1 = new Owner();
        owner1.setFirstName("Dimass");
        owner1.setLastName("Kab4ikov");
        owner1.setAddress("Metallurgov 7");
        owner1.setCity("Cherepovets");
        owner1.setTelephone("79219294284");

        Pet dimassPet = new Pet();
        dimassPet.setPetType(savedAbobusPetType);
        dimassPet.setOwner(owner1);
        dimassPet.setBirthDate(LocalDate.now());
        dimassPet.setName("Sus");
        owner1.getPets().add(dimassPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Garik");
        owner2.setLastName("Yorikov");
        owner2.setAddress("Stoykosti 7k2");
        owner2.setCity("VETERANOV");
        owner2.setTelephone("2281488");

        Pet gariksPet = new Pet();
        gariksPet.setPetType(savedLizardPetType);
        gariksPet.setOwner(owner2);
        gariksPet.setBirthDate(LocalDate.now());
        gariksPet.setName("Cocodrilo");
        owner2.getPets().add(gariksPet);

        ownerService.save(owner2);

        Visit cocodriloVisit = new Visit();
        cocodriloVisit.setPet(gariksPet);
        cocodriloVisit.setDate(LocalDate.now());
        cocodriloVisit.setDescription("Yasheritsa covidom zabolela");


        Visit abobusVisit = new Visit();
        abobusVisit.setPet(dimassPet);
        abobusVisit.setDate(LocalDate.now());
        abobusVisit.setDescription("SUS have visited vet-clinic");

        System.out.println("Zagruzil ownerow =)");


        Vet vet1 = new Vet();
        vet1.setFirstName("Amogus");
        vet1.setLastName("Abobus");
        vet1.getSpecialties().add(savedSusology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Яков");
        vet2.setLastName("Шышка");
        vet2.getSpecialties().add(savedAnesthesiology);

        vetService.save(vet2);

        System.out.println("Zagruzil vetov =)");
    }
}
