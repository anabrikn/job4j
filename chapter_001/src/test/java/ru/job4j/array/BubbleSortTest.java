package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] input = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = sort.sort(input);
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] input = new int[] {1, 5, 4, 2, 3};
        int[] result = sort.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortArrayWithElevenElementsThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] input = new int[] {1, 0, 4, 2, 3, 1, 7, 8, 0, 5, -2};
        int[] result = sort.sort(input);
        int[] expect = new int[] {-2, 0, 0, 1, 1, 2, 3, 4, 5, 7, 8};
        assertThat(result, is(expect));
    }
}
