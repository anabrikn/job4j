package ru.job4j.tracker.singletonTracker;
import ru.job4j.tracker.Item;

public class TrackerSingleEagerLoading {
    private static final TrackerSingleEagerLoading INSTANCE = new TrackerSingleEagerLoading();

    private TrackerSingleEagerLoading() {
    }

    public static TrackerSingleEagerLoading getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return item;
    }
}
