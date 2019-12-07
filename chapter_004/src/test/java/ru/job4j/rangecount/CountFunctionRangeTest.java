package ru.job4j.rangecount;

import org.junit.Test;

import static java.lang.Math.log;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

public class CountFunctionRangeTest {
    @Test
    public void whenLinearFunc() {
        CountFunctionRange cou = new CountFunctionRange();
        List<Double> result = cou.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunc() {
        CountFunctionRange cou = new CountFunctionRange();
        List<Double> result = cou.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunc() {
        CountFunctionRange cou = new CountFunctionRange();
        List<Double> result = cou.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(log(5), log(6), log(7));
        assertThat(result, is(expected));
    }
}