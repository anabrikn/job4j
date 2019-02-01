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
    public void doctorTest() {
        Doctor doctor = new Doctor("Кто");
        Patient patient = new Patient("Чупакабра", "Головная боль");
        doctor.cure(patient);

        String result = patient.getSymptoms();
        String expect = "I feel good!";
        assertThat(result, is(expect));
    }
}
