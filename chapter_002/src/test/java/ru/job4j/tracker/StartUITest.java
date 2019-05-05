package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
/**
 * @author anna brik
 * @version 1
 * @since 20.03.19
 */
public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }


    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 6));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteItemItIsNotFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 1));
        String itemId = item.getId();
        Input input = new StubInput(new String[]{"0", "test1 name", "desc1",
                                                "0", "test2 name", "desc2",
                                                "0", "test3 name", "desc3",
                                                "3", itemId, "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(itemId));
    }

    @Test
    public void whenUserFindItemByIdIfItemIsFoundItIsPrintToConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 1));
        Input input = new StubInput(new String[]{"0", "test1 name", "desc1",
                "0", "test2 name", "desc2",
                "4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
