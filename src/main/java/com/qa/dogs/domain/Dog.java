package com.qa.dogs.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String breed;
    private double cost;

    public Dog(long id, String name, String breed,  double cost) {
        super();
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.cost = cost;
    }

    public Dog() {
        // TODO Auto-generated constructor stub
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Dog [ID=" + this.id + ", name=" + this.name + ", breed=" + this.breed + ", cost=" + this.cost + "]";
    }

}
