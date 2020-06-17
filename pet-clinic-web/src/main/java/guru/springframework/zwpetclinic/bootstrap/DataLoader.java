package guru.springframework.zwpetclinic.bootstrap;

import guru.springframework.zwpetclinic.model.Owner;
import guru.springframework.zwpetclinic.model.PetType;
import guru.springframework.zwpetclinic.model.Vet;
import guru.springframework.zwpetclinic.services.OwnerService;
import guru.springframework.zwpetclinic.services.PetTypeService;
import guru.springframework.zwpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("Pet Type loaded....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("W");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("G");
        ownerService.save(owner2);

        System.out.println("Owners loaded....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("A");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("P");
        vetService.save(vet2);

        System.out.println("Vets loaded....");
    }
}
