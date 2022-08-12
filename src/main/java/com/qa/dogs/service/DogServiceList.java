package com.qa.dogs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dogs.domain.Dog;

@Service
public class DogServiceList implements DogService {

    private List<Dog> dogs;

    public DogServiceList() {
        super();
        this.dogs = new ArrayList<>();
        this.dogs.add(new Dog("Blake", "Husky", 500.0));
    }

    @Override
    public Dog makeDog(Dog dog) {
        this.dogs.add(dog);
        return dogs.get(this.dogs.size() - 1);
    }

    @Override
    public List<Dog> getAllDogs() {
        return this.dogs;
    }

    @Override
    public Dog getById(int id) {
        return this.dogs.get(id);
    }

    @Override
    public Dog updateDog(int id, String name, String breed, Double cost) {
        Dog toUpdate = this.dogs.get(id);

        if (name != null && !name.isBlank())
            toUpdate.setName(name);
        if (breed != null)
            toUpdate.setBreed(breed);
        if (cost != null)
            toUpdate.setCost(cost);

        return toUpdate;
    }

    @Override
    public void delete(int id) {
        this.dogs.remove(id);
    }

}
