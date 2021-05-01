package com.company.equals;

import java.util.Objects;

public class Pet extends Animal {
    String name;
    int age;

    public Pet(String type, String name, int age) {
        super(type);
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}