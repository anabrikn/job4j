package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author anna brik
 * @version 1
 * @since 02.01.19
 */
public class FindLoopTest {
    @Test
    public void whenArrayHasElement5ThenIndex0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasElement16ThenIndex2() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {0, -2, 16, 45, 14};
        int value = 16;
        int result = find.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasElementMinus2ThenIndex1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {0, -2, 16, 45, 14};
        int value = -2;
        int result = find.indexOf(input, value);
        int expect = 1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasNoElement22ThenIndexMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {0, -2, 16, 45, 14};
        int value = 22;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
