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
    public Dog makeDog(@RequestBody Dog dog) {
        System.out.println("Body: " + dog);
        return this.service.makeDog(dog);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public List<Dog> getAllDogs() {
        return this.service.getAllDogs();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Dog> getById(@PathVariable int id) {
        System.out.println("ID: " + id);
        return new ResponseEntity<Dog>(this.service.getById(id), HttpStatus.I_AM_A_TEAPOT);
    }

    @PatchMapping("/update/{id}")
    public Dog updateDog(@PathVariable int id, @PathParam("name") String name, @PathParam("breed") String breed,
                          @PathParam("cost") Double cost) {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("BREED: " + breed);
        System.out.println("COST: " + cost);

        return this.service.updateDog(id, name, breed, cost);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable int id) {
        System.out.println("ID: " + id);
        this.service.delete(id);
    }
}
