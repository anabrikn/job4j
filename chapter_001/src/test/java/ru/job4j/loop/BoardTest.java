package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author anna brik
 * @version 1
 * @since 01.01.19
 */
public class BoardTest {
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("X X%s X %sX X%s", line, line, line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("X X X%s X X %sX X X%s X X %s", line, line, line, line);
    }

    @Test
    public void whenPaintBoardWithWidthEightAndHeightFourThenStringWithEightColsAndEightRows() {
        Board board = new Board();
        String result = board.paint(8, 8);
        final String line = System.getProperty("line.separator");
        String expected = String.format("X X X X %s X X X X%sX X X X %s X X X X%sX X X X %s X X X X%sX X X X %s X X X X%s", line, line, line, line, line, line, line, line);
    }
}
