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
    public void whenUserAddItemAndFind() {
        Item item = tracker.add(new Item("test name", "desc", 6));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append("Меню.\n")
                                .append("0. Add new Item\n")
                                .append("1. Show all items\n")
                                .append("2. Edit item\n")
                                .append("3. Delete item\n")
                                .append("4. Find item by Id\n")
                                .append("5. Find items by name\n")
                                .append("6. Exit Program\n")
                                .append("Вывод всех заявок.\n")
                                .append("ID заявки: " + item.getId() + " Имя заявки: " + item.getName()
                                        + " Описание заявки: " + item.getDescription() + " Комментарии к заявке: " + item.getComments()
                                        + " Врмя создания заявки: " + item.getTime() + " Hash: "  + item.hashCode())
                                .append("\n")
                                .append("Меню.\n")
                                .append("0. Add new Item\n")
                                .append("1. Show all items\n")
                                .append("2. Edit item\n")
                                .append("3. Delete item\n")
                                .append("4. Find item by Id\n")
                                .append("5. Find items by name\n")
                                .append("6. Exit Program\n")
                                .toString()
                )
        );
    }
}