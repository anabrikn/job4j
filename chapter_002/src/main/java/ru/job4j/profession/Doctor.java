package ru.job4j.profession;
/**
 * @author anna brik
 * @version 1
 * @since 31.01.19
 */
public class Doctor extends Profession {
    public Doctor(String name) {
        super(name);
    }

    /**
     * Метод устанавливает диагноз в зависимости от симптомов пациента.
     * @param patient пациент, которому необходимо поставить диагноз.
     * @return поставленный диагноз.
     */
    public Diagnose toDiagnose(Patient patient) {
        Diagnose diagnose = new Diagnose(patient.getSymptoms());
        patient.setDiagnose(diagnose);
        return diagnose;
    }

    /**
     * Метод выполняет лечение в зависимости от диагноза поставленного пациенту, убирая симптомы.
     * @param patient пациент, которому необходимо выполнить назначения врача.
     */
    public void cure(Patient patient) {
        patient.setDiagnose(toDiagnose(patient));
        if (patient.getDiagnose().getPrescription().equals("Голованеболин")) {
            patient.setSymptoms("I feel good!");
        }
    }
}
