package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 01.02.19
 */
public class Engineer extends Profession {
    public Engineer(String name) {
        super(name);
    }

    /**
     * Метод устанавливает зданию статус - построено оно или нет.
     * @param house здание для проверки построено оно или нет.
     */
    public void build(House house) {
        house.setBuilt(true);
    }
}
