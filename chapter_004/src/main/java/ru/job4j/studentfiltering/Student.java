package ru.job4j.studentfiltering;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int score;
    private String surname;

    public Student(String surname, int score) {
        this.score = score;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }


    /*
    @Override
    public int compare(Student student, Student anotherStudent) {
        if (student.getScore() > anotherStudent.getScore()) {
            return 1;
        } else if (student.getScore() < anotherStudent.getScore()) {
            return -1;
        }
        return 0;

    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && getSurname().equals(student.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + '}';
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.score, this.score);
    }
}
