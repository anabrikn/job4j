package ru.job4j.tracker;
/**
 * @author anna brik
 * @version 1
 * @since 21.06.19
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
