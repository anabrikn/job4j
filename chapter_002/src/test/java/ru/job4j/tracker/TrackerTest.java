package ru.job4j.tracker;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
/**
 * @author anna brik
 * @version 1
 * @since 02.02.19
 */
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenNewItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 1234L);
        Item third = new Item("test3", "testDescription", 12345L);
        Item fourth = new Item("test4", "testDescription", 123456L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        Item[] guessArray = {first, third, fourth};
        tracker.delete(second.getId());
        assertThat(tracker.findAll(), is(guessArray));
    }

    @Test
    public void whenAllItemsAreFound() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 1234L);
        Item third = new Item("test3", "testDescription", 12345L);
        Item fourth = new Item("test4", "testDescription", 123456L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        Item[] guessArray = {first, second, third, fourth};

        assertThat(tracker.findAll(), is(guessArray));
    }

    @Test
    public void whenItemsAreFoundByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 1234L);
        Item third = new Item("test3", "testDescription", 12345L);
        Item fourth = new Item("test2", "testDescription", 123456L);
        Item fifth = new Item("test5", "testDescription", 1234567L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.add(fifth);
        Item[] resultArray = {second, fourth};
        assertThat(tracker.findByName("test2"), is(resultArray));
    }

    @Test
    public void whenItemsAreFoundByID() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 1234L);
        Item third = new Item("test3", "testDescription", 12345L);
        Item fourth = new Item("test2", "testDescription", 123456L);
        Item fifth = new Item("test5", "testDescription", 1234567L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.add(fifth);
        String id = second.getId();
        assertThat(tracker.findById(id), is(second));
    }

    @Test
    public void whenItemsAreNotFoundByID() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 1234L);
        Item third = new Item("test3", "testDescription", 12345L);
        Item fourth = new Item("test2", "testDescription", 123456L);
        Item fifth = new Item("test5", "testDescription", 1234567L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.add(fifth);
        assertNull(tracker.findById("ggggg"));
    }
}
