package guru.springframework.zwpetclinic.services.map;

import guru.springframework.zwpetclinic.model.Owner;
import guru.springframework.zwpetclinic.services.CrudService;
import guru.springframework.zwpetclinic.services.OwnerService;
import guru.springframework.zwpetclinic.services.PetService;
import guru.springframework.zwpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{
    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object!=null){
            if(!object.getPets().isEmpty()){
                object.getPets().forEach(pet -> {
                    if(pet.getType()!=null){
                        if(pet.getType().getId()==null){
                            pet.setType(petTypeService.save(pet.getType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId()==null){
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastname) {
        return null;
    }
}
