package guru.springframework.zwpetclinic.repositories;

import guru.springframework.zwpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
