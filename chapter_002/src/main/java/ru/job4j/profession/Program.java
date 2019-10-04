package ru.job4j.profession;

public class Program {
    private String name;
    private boolean isMade = false;

    /**
     * Конструктор, в котором устанавливаются значения следующим полям:
     * @param name название постройки.
     */
    public Program(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMade() {
        return isMade;
    }

    public void setMade(boolean made) {
        isMade = made;
    }
}
