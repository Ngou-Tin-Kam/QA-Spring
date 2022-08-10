package com.qa.dogs.service;

import java.util.List;

import com.qa.dogs.repos.DogRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.dogs.domain.Dog;

@Service
@Primary
public class DogServiceDB implements DogService {

    private DogRepo repo;

    public DogServiceDB(DogRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public Dog makeDog(Dog dog) {
       return this.repo.save(dog);
    }

    @Override
    public List<Dog> getAllDogs() {
        return this.repo.findAll();
    }

    @Override
    public Dog getById(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public Dog updateDog(int id, String name, String breed, Double cost) {
        Dog toUpdate = this.getById(id);

        if (name != null && !name.isBlank())
            toUpdate.setName(name);
        if (breed != null)
            toUpdate.setBreed(breed);
        if (cost != null)
            toUpdate.setCost(cost);

        return this.repo.save(toUpdate);
    }

    @Override
    public void delete(int id) {
        this.repo.deleteById(id);

    }
}
