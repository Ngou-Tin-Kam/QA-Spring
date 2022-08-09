package com.qa.dogs.service;

import java.util.List;

import com.qa.dogs.domain.Dog;

public class DogService {

    Dog makeDog(Dog dog);

    List<Dog> getAllDogs();

    Dog getById(long id);

    Biscuit updateDog(long id, String name, String breed, Double cost);

    void delete(long id);
}
