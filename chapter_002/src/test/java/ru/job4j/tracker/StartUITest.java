package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author anna brik
 * @version 1
 * @since 20.03.19
 */

public class StartUITest {
    private Tracker tracker;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String MENU = new StringBuilder()
            .append("Меню.")
            .append(System.lineSeparator())
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator())
            .toString();

    @Before
    public void beforeTest() {
        System.out.println("execute before method");
        tracker = new Tracker(); // создаём Tracker
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void afterTest() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }


    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
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
        Item item = tracker.add(new Item("test name", "desc", 1));
        Input input = new StubInput(new String[]{"0", "test1 name", "desc1",
                "0", "test2 name", "desc2",
                "4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenUserAddItemAndFound() {
        Item item = tracker.add(new Item("test name", "desc", 6));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("Вывод всех заявок.")
                                .append(System.lineSeparator())
                                .append("ID заявки: ")
                                .append(item.getId())
                                .append(" Имя заявки: ")
                                .append(item.getName())
                                .append(" Описание заявки: ")
                                .append(item.getDescription())
                                .append(" Комментарии к заявке: ")
                                .append(item.getComments())
                                .append(" Врмя создания заявки: ")
                                .append(item.getTime())
                                .append(" Hash: ")
                                .append(item.hashCode())
                                .append(System.lineSeparator())
                                .append(MENU)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemsByName() {
        Item item1 = tracker.add(new Item("test1", "desc1", 6));
        Item item2 = tracker.add(new Item("test2", "desc2", 6));
        Item item3 = tracker.add(new Item("test3", "desc3", 6));
        Input input = new StubInput(new String[]{"5", "test2", "6"});
        new StartUI(input, tracker).init();

        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(MENU)
                                .append("Поиск заявки по имени.")
                                .append(System.lineSeparator())
                                .append("ID заявки: ")
                                .append(item2.getId())
                                .append(" Имя заявки: ")
                                .append(item2.getName())
                                .append(" Описание заявки: ")
                                .append(item2.getDescription())
                                .append(" Комментарии к заявке: ")
                                .append(item2.getComments())
                                .append(" Врмя создания заявки: ")
                                .append(item2.getTime())
                                .append(" Hash: ")
                                .append(item2.hashCode())
                                .append(System.lineSeparator())
                                .append(MENU)
                                .toString()
                )
        );
    }
}