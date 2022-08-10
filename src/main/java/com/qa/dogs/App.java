package com.qa.dogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.dogs.rest.DogController;
import com.qa.dogs.service.DogService;
import com.qa.dogs.service.DogServiceDB;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("SERVICE: " + context.getBean(DogService.class));
        System.out.println("CONTROLLER: " + context.getBean(DogController.class));

        DogController controller = new DogController(new DogServiceDB());
    }
}
