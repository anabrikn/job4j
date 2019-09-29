package ru.job4j.tracker.singletontracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 * @author anna brik
 * @version 1
 * @since 28.09.19
 */

public class TrackerSingleEnumTest {
    @Test
    public void whenCreateSecondTrackerSingleEnum() {
        TrackerSingleEnum trackerSingleFirst = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum trackerSingleSecond = TrackerSingleEnum.INSTANCE;
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }

    @Test
    public void whenCreateSecondTrackerSingleLazyLoading() {
        TrackerSingleLazyLoading trackerSingleFirst = TrackerSingleLazyLoading.getInstance();
        TrackerSingleLazyLoading trackerSingleSecond = TrackerSingleLazyLoading.getInstance();
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }

    @Test
    public void whenCreateSecondTrackerSingleEagerLoading() {
        TrackerSingleEagerLoading trackerSingleFirst = TrackerSingleEagerLoading.getInstance();
        TrackerSingleEagerLoading trackerSingleSecond = TrackerSingleEagerLoading.getInstance();
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }

    @Test
    public void whenCreateSecondTrackerSingleLazyInner() {
        TrackerSingleLazyInner trackerSingleFirst = TrackerSingleLazyInner.getInstance();
        TrackerSingleLazyInner trackerSingleSecond = TrackerSingleLazyInner.getInstance();
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }
}
