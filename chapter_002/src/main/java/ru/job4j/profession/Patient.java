package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 31.01.19
 */
public class Patient {
    public String name;
    private String symptoms;
    private Diagnose diagnose;
    private int appendicitis = 1;
    private int teeth = 32;

    /**
     * Конструктор
     * @param name имя пациента.
     * @param symptoms симптомы, с которыми обращается пациент.
     */
    public Patient(String name, String symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }


    public Diagnose getDiagnose() {
        return this.diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getAppendicitis() {
        return appendicitis;
    }

    public void setAppendicitis(int appendicitis) {
        this.appendicitis = appendicitis;
    }

    public int getTeeth() {
        return teeth;
    }

    public void setTeeth(int teeth) {
        this.teeth = teeth;
    }
}
