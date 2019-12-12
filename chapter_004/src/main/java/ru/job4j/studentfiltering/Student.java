package ru.job4j.studentfiltering;

public class Student {
    int score;

    public Student(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + '}';
    }
}
