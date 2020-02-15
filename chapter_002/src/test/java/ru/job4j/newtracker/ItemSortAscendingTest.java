package ru.job4j.newtracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemSortAscendingTest {
    @Test
    public void when() {
        Item first = new Item("Первый");
        Item third = new Item("Третий");
        Item fifth = new Item("Пятый");

        first.setId("1");
        third.setId("3");
        fifth.setId("5");

        List<Item> items = Arrays.asList(fifth, first, third);
        items.sort(new ItemSortAscending());
        assertThat(items, is(List.of(first, third, fifth)));
    }
}
