package guru.springframework.zwpetclinic.bootstrap;

import guru.springframework.zwpetclinic.model.Owner;
import guru.springframework.zwpetclinic.model.Vet;
import guru.springframework.zwpetclinic.services.OwnerService;
import guru.springframework.zwpetclinic.services.VetService;
import guru.springframework.zwpetclinic.services.map.OwnerServiceMap;
import guru.springframework.zwpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("W");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("G");
        ownerService.save(owner2);

        System.out.println("Owners loaded....");

        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("A");
        vetService.save(vet1);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("P");
        vetService.save(vet2);

        System.out.println("Vets loaded....");
    }
}
