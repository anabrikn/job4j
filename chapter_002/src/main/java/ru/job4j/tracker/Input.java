package ru.job4j.tracker;
/**
 * @author anna brik
 * @version 1
 * @since 03.03.19
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
