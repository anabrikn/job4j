package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenAreaSetThreePointsInOnePlace() {
        Point a = new Point(2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenAreaSetTwoPointsInOnePlace() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenAreaSetThreePointsInOneLine() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(6, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1;
        assertThat(result, closeTo(expected, 0.1));
    }
}
