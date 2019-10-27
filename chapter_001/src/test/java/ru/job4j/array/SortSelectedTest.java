package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {
    @Test
    public void whenSort() {
        int[] input = new int[] {3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortThreeElements() {
        int[] input = new int[] {10, -10, 1};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {-10, 1, 10};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortFiveElements() {
        int[] input = new int[] {18, -2, 10, 1, -60};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {-60, -2, 1, 10, 18};
        assertThat(result, is(expect));
    }
}
