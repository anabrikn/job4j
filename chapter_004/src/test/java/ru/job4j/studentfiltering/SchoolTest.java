package ru.job4j.studentfiltering;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

public class SchoolTest {
    @Test
    public void whenStudentsScoreMoreThen70() {
        Student student1 = new Student(99);
        Student student2 = new Student(11);
        Student student3 = new Student(88);
        Student student4 = new Student(22);
        Student student5 = new Student(77);
        Student student6 = new Student(33);
        Student student7 = new Student(66);
        Student student8 = new Student(44);
        Student student9 = new Student(55);
        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        School sc = new School();
        List<Student> classA = sc.collect(students, i -> i.score > 70);
        List<Student> expected = Arrays.asList(student5, student3, student1);
        assertTrue(expected.containsAll(classA));
    }

    @Test
    public void whenStudentsScoreMoreThen50AndLessThan70() {
        Student student1 = new Student(99);
        Student student2 = new Student(11);
        Student student3 = new Student(88);
        Student student4 = new Student(22);
        Student student5 = new Student(77);
        Student student6 = new Student(33);
        Student student7 = new Student(66);
        Student student8 = new Student(44);
        Student student9 = new Student(55);
        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        School sc = new School();
        List<Student> classB = sc.collect(students, i -> i.score >= 50 && i.score < 70);
        List<Student> expected = Arrays.asList(student9, student7);
        assertTrue(expected.containsAll(classB));
    }

    @Test
    public void whenStudentsScoreLessThan50() {
        Student student1 = new Student(99);
        Student student2 = new Student(11);
        Student student3 = new Student(88);
        Student student4 = new Student(22);
        Student student5 = new Student(77);
        Student student6 = new Student(33);
        Student student7 = new Student(66);
        Student student8 = new Student(44);
        Student student9 = new Student(55);
        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        School sc = new School();
        List<Student> classC = sc.collect(students, i -> i.score >= 0 && i.score < 50);
        List<Student> expected = Arrays.asList(student2, student4, student6, student8);
        assertTrue(expected.containsAll(classC));
    }
}
