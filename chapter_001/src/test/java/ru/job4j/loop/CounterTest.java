package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author anna brik
 * @version 1
 * @since 28.12.18
 */
public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }

    @Test
    public void whenSumEvenNumbersFromOneToOneThenZero() {
        Counter counter = new Counter();
        int result = counter.add(1, 1);
        assertThat(result, is(0));
    }

    @Test
    public void whenSumEvenNumbersFromZeroToFourThenSix() {
        Counter counter = new Counter();
        int result = counter.add(0, 4);
        assertThat(result, is(6));
    }
}
