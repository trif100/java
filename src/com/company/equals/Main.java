package com.company.equals;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Котик");
        Animal animal2 = new Animal("Котик");
        Pet pet = new Pet("Котик", "Васька", 3);

        System.out.println("Котик из класса Animal и из класса Pet:");
        System.out.println(animal1.equals(pet));
        System.out.println(pet.equals(animal1));
        System.out.println();

        System.out.println("Два котика из класса Animal и один из класса Pet:");
        System.out.println(animal1.equals(animal2));
        System.out.println(animal2.equals(animal1));
        System.out.println(animal1.equals(pet));
        System.out.println(pet.equals(animal1));
        System.out.println(animal2.equals(pet));
        System.out.println(pet.equals(animal2));
    }
}