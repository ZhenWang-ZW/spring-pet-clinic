package guru.springframework.zwpetclinic.bootstrap;

import guru.springframework.zwpetclinic.model.*;
import guru.springframework.zwpetclinic.services.*;
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

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size()==0)
            loadData();
    }

    private void loadData() {
        /* PetType*/
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType catType = petTypeService.save(cat);

        System.out.println("Pet Type loaded....");

        /* Specialty*/
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Specialty loaded....");

        /* Owner*/
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("W");
        owner1.setAddress("52 Laurence st Drogheda");
        owner1.setCity("Drogheda");
        owner1.setTelephone("(041)9837406");
        /* Pet*/
        Pet micksPet = new Pet();
        micksPet.setType(dogType);
        micksPet.setName("Rosco");
        micksPet.setDob(LocalDate.now());
        owner1.getPets().add(micksPet);

        ownerService.save(owner1);

        /* Owner*/
        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("G");
        owner2.setAddress("Church st Cootehill");
        owner2.setCity("Cootehill");
        owner2.setTelephone("(049)5556324");
        /* Pet*/
        Pet fionasPet = new Pet();
        fionasPet.setType(catType);
        fionasPet.setName("Cat");
        fionasPet.setDob(LocalDate.now());
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        System.out.println("Owners loaded....");
        /* Vet*/
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("A");
        vet1.getSpecialities().add(dentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("P");
        vet2.getSpecialities().add(radiology);
        vetService.save(vet2);

        System.out.println("Vets loaded....");
    }
}
