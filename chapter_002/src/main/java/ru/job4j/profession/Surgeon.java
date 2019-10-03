package ru.job4j.profession;

public class Surgeon extends Doctor {
    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void cutAppendicitis(Patient patient) {
        if (patient.getAppendicitis() > 0) {
            patient.setAppendicitis(0);
        }
        super.cure(patient);
    }
}
