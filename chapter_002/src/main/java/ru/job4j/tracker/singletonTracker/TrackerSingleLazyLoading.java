package ru.job4j.tracker.singletonTracker;
import ru.job4j.tracker.Item;

public class TrackerSingleLazyLoading {
    private static TrackerSingleLazyLoading instance;
    private TrackerSingleLazyLoading() {
    }

    public static TrackerSingleLazyLoading getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazyLoading();
        }
        return instance;
    }

    public Item add(Item item) {
        return item;
    }
}
