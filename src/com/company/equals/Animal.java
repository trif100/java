package com.company.equals;
import java.util.Objects;

public class Animal {
    String type;

    public Animal(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Animal animal = (Animal) o;
        return Objects.equals(type, animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}

