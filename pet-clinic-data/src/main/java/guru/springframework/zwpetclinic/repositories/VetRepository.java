package guru.springframework.zwpetclinic.repositories;

import guru.springframework.zwpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
