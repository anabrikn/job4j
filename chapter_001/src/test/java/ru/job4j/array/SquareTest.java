package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author anna brik
 * @version 1
 * @since 02.01.19
 */
public class SquareTest {
    @Test
    public void whenBound0ThenEmpty() {
        int bound = 0;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound1Then1() {
        int bound = 1;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound5Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound10Then149162536496481100() {
        int bound = 10;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        assertThat(rst, is(expect));
    }
}
