package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author anna brik
 * @version 1
 * @since 01.05.19
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +   ")
                                .append("\n")
                                .append("  + +  ")
                                .append("\n")
                                .append(" +   + ")
                                .append("\n")
                                .append("+++++++")
                                .toString()
                )
        );
    }
}

/*

 */