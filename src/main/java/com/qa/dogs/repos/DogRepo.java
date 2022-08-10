package com.qa.dogs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dogs.domain.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Integer> {

}
