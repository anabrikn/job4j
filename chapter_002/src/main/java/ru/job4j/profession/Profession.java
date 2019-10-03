package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 31.01.19
 */
public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;
    private String profession;
    /**
     * Конструктор создания объекта Profession
     * @param name имя.
     */
    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getProfession() {
        return profession;
    }
}
