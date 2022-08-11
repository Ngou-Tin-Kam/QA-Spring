package com.qa.dogs.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dogs.domain.Dog;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:dog-schema.sql", "classpath:dog-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class DogControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreateDog() throws Exception {
        Dog testDog = new Dog("Phillip", "Chihuahua", 200.00);
        RequestBuilder req = post("/createDog").content(this.mapper.writeValueAsString(testDog)).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        Dog testSavedDog = new Dog(3, "Phillip", "Chihuahua" , 200.00);
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedDog));

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testCreateButHardToRead() throws Exception {
        this.mvc.perform(
                        post("/createDog").content(this.mapper.writeValueAsString(new Dog("Phillip", "Chihuahua" , 200.00)))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(this.mapper.writeValueAsString(new Dog(3, "Phillip", "Chihuahua" , 200.00))));
    }

    @Test
    void testGetDog() throws Exception {
        List<Dog> dogs = List.of(new Dog(1, "Simmy", "Pug" , 600.00),
                new Dog(2, "Freshy", "French Bulldog" , 700.00));

        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(dogs));
        this.mvc.perform(get("/getAll")).andExpect(status().isOk()).andExpect(checkBody);
    }

    @Test
    void testGetDogById() throws Exception {
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(new Dog(1, "Simmy", "Pug" , 600.00)));

        this.mvc.perform(get("/get/1")).andExpect(status().isOk()).andExpect(checkBody);
    }

    @Test
    void testUpdateById() throws Exception {
        this.mvc.perform(
                patch("/update/1")
                        .param("name", "Barry")
                        .param("breed", "German Shepherd")
                        .param("cost", "300"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(this.mapper.writeValueAsString(new Dog(1, "Barry", "German Shepherd", 300))));
    }

    @Test
    void testRemoveById() throws Exception {
        this.mvc.perform(
                        delete("/remove/1"))
                .andExpect(status().isOk());
    }
}