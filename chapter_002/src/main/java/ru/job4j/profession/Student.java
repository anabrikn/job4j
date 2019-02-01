package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 01.02.19
 */
public class Student {
    private String name;
    private boolean isLearned;
    /**
     * Конструктор, в котором устанавливаются значения следующим полям:
     * @param name имя студента.
     */
    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public boolean isLearned() {
        return isLearned;
    }

    public void setLearned(boolean learned) {
        isLearned = learned;
    }
}
