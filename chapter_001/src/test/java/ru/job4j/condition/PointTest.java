package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenPointIn3DSpace() {
        Point k = new Point(4, 1, 3);
        Point n = new Point(6, 2, 5);

        double result3d = k.distance3D(n);
        assertThat(result3d, is(3.0));
    }

    @Test
    public void whenTwoPointIn3DSpace() {
        Point k = new Point(1, 1, 1);
        Point n = new Point(1, 3, 1);

        double result3d = k.distance3D(n);
        assertThat(result3d, is(2.0));
    }
}
