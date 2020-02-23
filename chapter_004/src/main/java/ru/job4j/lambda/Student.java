package ru.job4j.lambda;

import java.util.Set;

public class Student {
    private String name; // имя студета
    private Set<String> units; //список секций, которые посещает студент

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUnits() {
        return units;
    }
}
