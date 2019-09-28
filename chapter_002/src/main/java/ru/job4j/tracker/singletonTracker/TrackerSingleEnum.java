package ru.job4j.tracker.singletonTracker;
import ru.job4j.tracker.Item;
/**
 * @author anna brik
 * @version 1
 * @since 28.09.19
 */

public enum  TrackerSingleEnum {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }
}
