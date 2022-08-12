package com.qa.dogs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String breed;
    private double cost;

    public Dog(Integer id, String name, String breed, double cost) {
        super();
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.cost = cost;
    }

    public Dog(String name, String breed, double cost) {
        super();
        this.name = name;
        this.breed = breed;
        this.cost = cost;
    }

    public Dog() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Double.compare(dog.getCost(), getCost()) == 0 && Objects.equals(getId(), dog.getId()) && Objects.equals(getName(), dog.getName()) && Objects.equals(getBreed(), dog.getBreed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBreed(), getCost());
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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
