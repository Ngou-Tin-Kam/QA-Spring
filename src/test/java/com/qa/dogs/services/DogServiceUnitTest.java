package com.qa.dogs.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.dogs.domain.Dog;
import com.qa.dogs.repos.DogRepo;
import com.qa.dogs.service.DogService;

@SpringBootTest
@ActiveProfiles("test")
public class DogServiceUnitTest {

    @Autowired
    private DogService service;

    @MockBean
    private DogRepo repo;

    @Test
    void testUpdate() {

        final int id = 1;
        final String name = "Cookies";
        final String breed = "Pomsky";
        final double newCost = 1200.00;

        Dog expected = new Dog(id, name, breed, newCost);

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Dog(id, name, breed, 1000.00)));
        Mockito.when(this.repo.save(new Dog(id, name, breed, newCost)))
                .thenReturn(new Dog(id, name, breed, newCost));

        Dog actual = this.service.updateDog(id, null, breed, newCost);

        assertEquals(expected, actual);
    }
}