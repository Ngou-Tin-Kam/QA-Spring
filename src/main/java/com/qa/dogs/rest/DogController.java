package com.qa.dogs.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dogs.domain.Dog;
import com.qa.dogs.service.DogService;

@RestController
public class DogController {

        private DogService service;

    @Autowired
    public DogController(DogService service) {
        super();
        this.service = service;
    }

    @GetMapping("/hello")
    public String greeting() {
        return "Hello, world!";
    }

    @PostMapping("/createDog")
    public void makeDog(@RequestBody Dog dog) {
        System.out.println("Body: " + dog);
        return this.service.makeDog(dog);
    }

    @GetMapping("/getAll")
    public List<Dog> getAllBiscuits() {
        return this.dogs;
    }

    @GetMapping("/get/{id}")
    public Dog getById(@PathVariable long id) {
        System.out.println("ID: " + id);
        return this.dogs.get(id);
    }

    @PatchMapping("/update/{id}")
    public void updateDog(@PathVariable long id, @PathParam("name") String name, @PathParam("breed") String breed,
                              @PathParam("cost") Double cost) {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("BREED: " + breed);
        System.out.println("COST: " + cost);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable int id) {
        System.out.println("ID: " + id);
    }
}
