package ru.job4j.profession;

public class Builder extends Engineer {
    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    /**
     * Метод устанавливает зданию статус - построено оно или нет.
     * @param house здание для проверки построено оно или нет.
     */
    public void build(House house) {
        house.setBuilt(true);
    }
}
