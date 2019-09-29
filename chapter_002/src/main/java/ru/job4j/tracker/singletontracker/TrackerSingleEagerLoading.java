package ru.job4j.tracker.singletontracker;
import ru.job4j.tracker.Item;
/**
 * @author anna brik
 * @version 1
 * @since 28.09.19
 */
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
