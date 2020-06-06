package guru.springframework.zwpetclinic.services.map;

import guru.springframework.zwpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object cannot be null!");
        }
        return object;
    }

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id){
        map.remove(id);
    }

    private Long getNextId(){
        Long id = null;
        try{
            id = Collections.max(map.keySet()) + 1;
        }catch(NoSuchElementException e){
            id=1L;
        }
        return id;
    }
}
