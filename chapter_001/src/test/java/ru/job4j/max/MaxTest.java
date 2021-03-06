package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author anna brik
 * @version 1
 * @since 26.12.18
 */
public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int result = maximum.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maximum = new Max();
        int result = maximum.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstEqualsSecond() {
        Max maximum = new Max();
        int result = maximum.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstLessSecondAndThird() {
        Max maximum = new Max();
        int result = maximum.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstMoreSecondAndThird() {
        Max maximum = new Max();
        int result = maximum.max(5, 2, 3);
        assertThat(result, is(5));
    }

    @Test
    public void whenFirstEqualsSecondAndThird() {
        Max maximum = new Max();
        int result = maximum.max(1, 1, 1);
        assertThat(result, is(1));
    }

    @Test
    public void whenSecondFirstMoreFirstAndThird() {
        Max maximum = new Max();
        int result = maximum.max(4, 5, 1);
        assertThat(result, is(5));
    }

    @Test
    public void whenNeedCompareFourNumbers() {
        Max maximum = new Max();
        int result = maximum.max(4, 5, 2, 3);
        assertThat(result, is(5));
    }
}

