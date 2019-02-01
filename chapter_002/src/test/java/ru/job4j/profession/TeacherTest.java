package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author anna brik
 * @version 1
 * @since 02.02.19
 */
public class TeacherTest {
    @Test
    public void teacherTest() {
        Teacher teacher = new Teacher("Христиан Вольф");
        Student student = new Student("Михаил Ломоносов");
        teacher.teach(student);

        boolean result = student.isLearned();
        boolean expect = true;
        assertThat(result, is(expect));
    }
}
