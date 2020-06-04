package guru.springframework.zwpetclinic.services;

import guru.springframework.zwpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    public Vet findById(Long id);
    public Vet save(Vet vet);
    public Set<Vet> findAll();
}
