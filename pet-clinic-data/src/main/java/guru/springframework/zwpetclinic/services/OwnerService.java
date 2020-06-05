package guru.springframework.zwpetclinic.services;

import guru.springframework.zwpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
    public Owner findByLastName(String lastname);
}
