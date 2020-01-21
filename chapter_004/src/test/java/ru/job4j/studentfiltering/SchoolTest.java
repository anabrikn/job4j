package ru.job4j.studentfiltering;

import org.junit.Test;
import java.util.*;
import java.util.List;
import java.util.Map;
import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SchoolTest {
    @Test
    public void whenStudentsScoreMoreThen70() {
        Student student1 = new Student("Королев", 99);
        Student student2 = new Student("Самоваров", 11);
        Student student3 = new Student("Астанина", 88);
        Student student4 = new Student("Галушко", 22);
        Student student5 = new Student("Поляков", 77);
        Student student6 = new Student("Шкипер", 33);
        Student student7 = new Student("Самоваров", 66);
        Student student8 = new Student("Архипова", 44);
        Student student9 = new Student("Галушко", 55);
        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        School sc = new School();
        List<Student> classA = sc.collect(students, i -> i.getScore() > 70);
        List<Student> expected = Arrays.asList(student5, student3, student1);
        assertTrue(expected.containsAll(classA));
    }

    @Test
    public void whenStudentsScoreMoreThen50AndLessThan70() {
        Student student1 = new Student("Королев", 99);
        Student student2 = new Student("Самоваров", 11);
        Student student3 = new Student("Астанина", 88);
        Student student4 = new Student("Галушко", 22);
        Student student5 = new Student("Поляков", 77);
        Student student6 = new Student("Шкипер", 33);
        Student student7 = new Student("Самоваров", 66);
        Student student8 = new Student("Архипова", 44);
        Student student9 = new Student("Галушко", 55);
        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        School sc = new School();
        List<Student> classB = sc.collect(students, i -> i.getScore() >= 50 && i.getScore() < 70);
        List<Student> expected = Arrays.asList(student9, student7);
        assertTrue(expected.containsAll(classB));
    }

    @Test
    public void whenStudentsScoreLessThan50() {
        Student student1 = new Student("Королев", 99);
        Student student2 = new Student("Самоваров", 11);
        Student student3 = new Student("Астанина", 88);
        Student student4 = new Student("Галушко", 22);
        Student student5 = new Student("Поляков", 77);
        Student student6 = new Student("Шкипер", 33);
        Student student7 = new Student("Самоваров", 66);
        Student student8 = new Student("Архипова", 44);
        Student student9 = new Student("Галушко", 55);
        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        School sc = new School();
        List<Student> classC = sc.collect(students, i -> i.getScore() >= 0 && i.getScore() < 50);
        List<Student> expected = Arrays.asList(student2, student4, student6, student8);
        assertTrue(expected.containsAll(classC));
    }

    /*
    1. Создать список учеников. Класс Student взять из задания "Фильтрация учеников"
    2. Преобразовать список учеников в Map.
    3. В качестве ключа использовать фамилию ученика.
    4. В качестве значение использовать объект ученика.
     */

    @Test
    public void whenToMapStudentsScoreMoreThen50AndLessThan70() {
        Student student1 = new Student("Королев", 99);
        Student student2 = new Student("Самоваров", 11);
        Student student3 = new Student("Астанина", 88);
        Student student4 = new Student("Галушко", 22);
        Student student5 = new Student("Поляков", 77);
        Student student6 = new Student("Шкипер", 33);
        Student student7 = new Student("Самоваров", 66);
        Student student8 = new Student("Архипова", 44);
        Student student9 = new Student("Галушко", 55);

        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        Map<String, Student> expected = new HashMap<>();
        expected.put(student7.getSurname(), student7);
        expected.put(student9.getSurname(), student9);
        School lm = new School();
        Map<String, Student> result = lm.collectConvertToMap(students, i -> i.getScore() >= 50 && i.getScore() < 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenToMapStudentsScoreMoreThen70() {
        Student student1 = new Student("Королев", 99);
        Student student2 = new Student("Самоваров", 11);
        Student student3 = new Student("Астанина", 88);
        Student student4 = new Student("Галушко", 22);
        Student student5 = new Student("Поляков", 77);
        Student student6 = new Student("Шкипер", 33);
        Student student7 = new Student("Самоваров", 66);
        Student student8 = new Student("Архипова", 44);
        Student student9 = new Student("Галушко", 55);

        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        Map<String, Student> expected = new HashMap<>();
        expected.put(student5.getSurname(), student5);
        expected.put(student3.getSurname(), student3);
        expected.put(student1.getSurname(), student1);
        School lm = new School();
        Map<String, Student> result = lm.collectConvertToMap(students, i -> i.getScore() >= 70 && i.getScore() < 100);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLevelOfTest() {
        Student student1 = new Student("Королев", 99);
        Student student2 = new Student("Самоваров", 11);
        Student student3 = new Student("Астанина", 88);
        Student student4 = new Student("Галушко", 22);
        Student student5 = new Student("Поляков", 77);
        Student student6 = new Student("Шкипер", 33);
        Student student7 = new Student("Самоваров", 66);
        Student student8 = new Student("Архипова", 44);
        Student student9 = new Student("Галушко", 55);

        List<Student> students = Arrays.asList(
                student1, student2, student3,
                null,
                student4, student5, student6,
                null,
                student7, student8, student9
        );

        School sc = new School();
        List<Student> result = sc.levelOf(students, 70);
        List<Student> expected = Arrays.asList(student1, student3, student5);
        assertThat(result, is(expected));
    }
}
