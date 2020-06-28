package guru.springframework.zwpetclinic.repositories;

import guru.springframework.zwpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
