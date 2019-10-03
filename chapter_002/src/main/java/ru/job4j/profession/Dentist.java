package ru.job4j.profession;

public class Dentist extends Doctor {
    public Dentist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void removeTooth(Patient patient) {
        patient.setTeeth(patient.getTeeth() - 1);
        super.cure(patient);
    }
}
