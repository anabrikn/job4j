package ru.job4j.newtracker;

public interface Input {
    String askStr(String question);
    int askInt(String question);
    int askInt(String question, int max);
}
