package guru.springframework.zwpetclinic.repositories;

import guru.springframework.zwpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
