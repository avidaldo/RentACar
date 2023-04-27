package org.example.repository;


import org.example.model.Entity;

import java.util.ArrayList;

public abstract class CrudRepository implements ICrudRepository<Entity> {

    public ArrayList<Entity> array;
    private static CrudRepository clientRepository;

    public CrudRepository() {
        array = new ArrayList<>();
    }


    public void add(Entity e){
        e.setId(nextIdAvailable());
        array.add(e);
    }

    public void update(Entity e){
        array.set(array.indexOf(findById(e.getId())), e);
    }

    public ArrayList findAll(){
        return array;
    }

    public void deleteById(Long id){
        for (Entity e : array) {
            if (e.getId() == id) {
                array.remove(e);
                break;
            }
        }
    }

    public Long nextIdAvailable(){
        if(!array.isEmpty()){
            return array.get(array.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    public Entity findById(Long id) {
        for (Entity e : array) {
               if(e.getId() == id){
                   return e;
               }
        }
        return null;
    }

    public void cleanUp(){
        array = new ArrayList<>();
    }

}
