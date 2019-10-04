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
    private Appendix appendix;
    private Tooth[] teeth;

    /**
     * Конструктор
     * @param name имя пациента.
     * @param symptoms симптомы, с которыми обращается пациент.
     */
    public Patient(String name, String symptoms, Appendix appendix, Tooth[] teeth) {
        this.name = name;
        this.symptoms = symptoms;
        this.appendix = appendix;
        this.teeth = teeth;
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

    public Appendix getAppendix() {
        return appendix;
    }

    public void setAppendix(Appendix appendix) {
        this.appendix = appendix;
    }

    public Tooth[] getTeeth() {
        return teeth;
    }

    public void setTeeth(Tooth[] teeth) {
        this.teeth = teeth;
    }
}
