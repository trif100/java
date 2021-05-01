package com.company;
import java.util.HashMap;
import java.util.Map;

public class MapExperiments {

    public static void main(String[] args) {
        String [] array =
                new String [] {"cat", "mouse", "mouse", "dog", "crocodile", "tiger", "deer", "cat", "mouse", "wolf"};
        Map<String, Integer> animals = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (animals.containsKey(array[i])) {
                Integer value = animals.get(array[i]);
                value++;
                animals.put(array[i], value);
                continue;
            }
            animals.put(array[i], 1);
        }
        System.out.println(animals);
    }
}
