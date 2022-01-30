package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Dimass");
        owner1.setLastName("Kab4ikov");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Garik");
        owner2.setLastName("Yorikov");

        ownerService.save(owner2);

        System.out.println("Zagruzil ownerow =)");

        Vet vet1 = new Vet();
        vet1.setFirstName("Amogus");
        vet1.setLastName("Abobus");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Яков");
        vet2.setLastName("Шышка");

        vetService.save(vet2);

        System.out.println("Zagruzil vetov =)");
    }
}
