package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author anna brik
 * @version 1
 * @since 02.02.19
 */
public class DoctorTest {
    @Test
    public void doctorSurgeonTest() {
        Surgeon doctor = new Surgeon("Кто", "Ктототамович", "хирург", "20.01.1860");
        Patient patient = new Patient("Чупакабра", "Боль в животе");
        doctor.cutAppendicitis(patient);

        String result = patient.getSymptoms();
        String expect = "I feel good!";
        assertThat(result, is(expect));
    }
    @Test
    public void doctorTest() {
        Dentist doctor = new Dentist("Кто", "Ктототамович", "хирург", "20.01.1860");
        Patient patient = new Patient("Чупакабра", "Боль в зубе");
        doctor.removeTooth(patient);

        String result = patient.getSymptoms();
        String expect = "I feel good!";
        assertThat(result, is(expect));
    }
}
