package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 31.01.19
 */
public class Diagnose {
    private String name;
    private String prescription;

    /**
     * Конструктор создания объекта Diagnose
     * @param symptoms симптомы, с которыми обращается пациент.
     */
    public Diagnose(String symptoms) {
        if (symptoms.equals("Боль в животе")) {
            this.name = "D";
            this.prescription = "Животонеболин";
        }
        if (symptoms.equals("Боль в зубе")) {
            this.name = "P";
            this.prescription = "Зубонеболин";
        }
    }

    public String getName() {
        return this.name;
    }

    public String getPrescription() {
        return this.prescription;
    }
}
