package ru.job4j.newtracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }


    @Test
    public void whenAddNewItemThenTrackerHasSameItemFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenDeleteItemThenNewItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        Item fourth = new Item("test4");
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
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        Item fourth = new Item("test4");
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
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        Item fourth = new Item("test2");
        Item fifth = new Item("test5");
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
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        Item fourth = new Item("test2");
        Item fifth = new Item("test5");
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
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        Item fourth = new Item("test2");
        Item fifth = new Item("test5");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.add(fifth);
        assertNull(tracker.findById("ggggg"));
    }
}