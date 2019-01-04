package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author anna brik
 * @version 1
 * @since 04.01.19
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[] {"a", "a", "a", "a", "b", "c", "d", "a"};
        String[] result = arrayDuplicate.remove(input);
        String[] expect = new String[] {"a", "d", "c", "b"};
        assertThat(result, is(expect));
    }
}
