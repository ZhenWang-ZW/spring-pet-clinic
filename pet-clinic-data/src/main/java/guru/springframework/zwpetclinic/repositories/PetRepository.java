package guru.springframework.zwpetclinic.repositories;

import guru.springframework.zwpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
