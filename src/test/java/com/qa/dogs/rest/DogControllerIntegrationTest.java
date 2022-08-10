package com.qa.dogs.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dogs.domain.Dog;

@SpringBootTest
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreateButHardToRead() throws Exception {
        this.mvc.perform(
                        post("/createDog").content(this.mapper.writeValueAsString(new Dog("Phillip", "Chihuahua" , 200.00)))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(this.mapper.writeValueAsString(new Dog(1, "Phillip", "Chihuahua" , 200.00))));
    }

    @Test
    void testCreateDog() throws Exception {
        Dog testDog = new Dog("Phillip", "Chihuahua", 200.00);
        RequestBuilder req = post("/createDog").content(this.mapper.writeValueAsString(testDog)).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        Dog testSavedDog = new Dog(2, "Phillip", "Chihuahua" , 200.00); //ID changed from 1 to 2, to test both tests at the same time as it is expected 2
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedDog));

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
}