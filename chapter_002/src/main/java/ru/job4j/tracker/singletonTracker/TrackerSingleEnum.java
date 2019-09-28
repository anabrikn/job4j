package ru.job4j.tracker.singletonTracker;
import ru.job4j.tracker.Item;

public enum  TrackerSingleEnum {
    INSTANCE; // здесь мы указываем перечисления.

    // Конструкторы и методы.
    public Item add(Item model) {
        return model;
    }
}
