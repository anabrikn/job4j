package ru.job4j.tracker.singletonTracker;
import ru.job4j.tracker.Item;

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
