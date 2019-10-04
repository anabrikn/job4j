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
        Tooth[] teeth = new Tooth[32];
        for (int i = 0; i < 32; i++) {
            teeth[i] = new Tooth(i + 1, false);
        }
        Surgeon doctor = new Surgeon("Кто", "Ктототамович", "хирург", "20.01.1860");
        Patient patient = new Patient("Чупакабра", "Боль в животе", new Appendix(true), teeth);
        doctor.cutAppendicitis(patient);

        String result = patient.getSymptoms();
        String expect = "I feel good!";
        assertThat(result, is(expect));
    }
    @Test
    public void doctorTest() {
        Tooth[] teeth = new Tooth[32];
        for (int i = 0; i < 32; i++) {
            teeth[i] = new Tooth(i + 1, true);
        }
        Dentist doctor = new Dentist("Кто", "Ктототамович", "дантист", "20.01.1860");
        Patient patient = new Patient("Чупакабра", "Боль в зубе", new Appendix(false), teeth);
        doctor.treatTeeth(patient);

        String result = patient.getSymptoms();
        String expect = "I feel good!";
        assertThat(result, is(expect));
    }
}
