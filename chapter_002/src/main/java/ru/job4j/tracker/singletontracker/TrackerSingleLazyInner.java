package ru.job4j.tracker.singletontracker;
import ru.job4j.tracker.Item;
/**
 * @author anna brik
 * @version 1
 * @since 28.09.19
 */
public class TrackerSingleLazyInner {
    private TrackerSingleLazyInner() {
    }

    public static TrackerSingleLazyInner getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item item) {
        return item;
    }

    private static final class Holder {
        private static final TrackerSingleLazyInner INSTANCE = new TrackerSingleLazyInner();
    }

}
