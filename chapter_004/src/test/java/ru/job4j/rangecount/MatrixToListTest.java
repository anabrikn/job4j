package ru.job4j.rangecount;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;

public class MatrixToListTest {
    @Test
    public void whenMatrixToList() {
        MatrixToList mtl = new MatrixToList();
        Integer[][] matrix = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = mtl.matrixToList(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}
