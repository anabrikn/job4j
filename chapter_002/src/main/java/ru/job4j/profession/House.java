package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 01.02.19
 */
public class House {
    private String name;
    private boolean isBuilt = false;

    /**
     * Конструктор, в котором устанавливаются значения следующим полям:
     * @param name название постройки.
     */
    public House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isBuilt() {
        return isBuilt;
    }

    public void setBuilt(boolean built) {
        isBuilt = built;
    }
}
