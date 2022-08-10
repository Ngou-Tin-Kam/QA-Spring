package com.qa.dogs.service;

import java.util.List;

import com.qa.dogs.domain.Dog;

public interface DogService {

    Dog makeDog(Dog dog);

    List<Dog> getAllDogs();

    Dog getById(int id);

    Dog updateDog(int id, String name, String breed, Double cost);

    void delete(int id);
}
