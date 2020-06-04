package guru.springframework.zwpetclinic.services;

import guru.springframework.zwpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    public Owner findByLastName(String lastname);
    public Owner findById(Long id);
    public Owner save(Owner owner);
    public Set<Owner> findAll();
}
