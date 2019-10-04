package ru.job4j.profession;

public class Dentist extends Doctor {
    public Dentist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void treatTeeth(Patient patient) {
        for (int i = 0; i < patient.getTeeth().length; i++) {
            if (patient.getTeeth()[i].isIll()) {
                patient.getTeeth()[i].setIll(false);
            }
        }
        super.cure(patient);
    }
}
