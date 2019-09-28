package ru.job4j.tracker.singletonTracker;
import ru.job4j.tracker.Item;
/**
 * @author anna brik
 * @version 1
 * @since 28.09.19
 */
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
