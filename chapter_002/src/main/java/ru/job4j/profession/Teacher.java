package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 01.02.19
 */
public class Teacher extends Profession {
    public Teacher(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }
    /**
     * Метод устанавливает студенту статус - обучен или нет.
     * @param student студент, переданный для обучения.
     */
    public void teach(Student student) {
        student.setLearned(true);
    }
}
