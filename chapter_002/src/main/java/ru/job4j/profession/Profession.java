package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 31.01.19
 */
public class Profession {
    private String name;
    private String profession;
    /**
     * Конструктор создания объекта Profession
     * @param name имя.
     */
    public Profession(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
