package guru.springframework.zwpetclinic.services.map;

import guru.springframework.zwpetclinic.model.Specialty;
import guru.springframework.zwpetclinic.model.Vet;
import guru.springframework.zwpetclinic.services.CrudService;
import guru.springframework.zwpetclinic.services.SpecialtyService;
import guru.springframework.zwpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(!object.getSpecialities().isEmpty()){
            object.getSpecialities().forEach(specialty -> {
                if(specialty.getId()==null){
                    specialty.setId(specialtyService.save(specialty).getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
