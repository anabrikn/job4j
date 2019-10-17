package ru.job4j.newtracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.hamcrest.core.Is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

public class StartUITest {
    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        ExitStubAction action = new ExitStubAction();
        new StartUI().init(input, new Tracker(), new UserAction[]{action});
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. === Exit Program ====")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        ExitStubAction action = new ExitStubAction();
        new StartUI().init(input, new Tracker(), new UserAction[]{action});
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"qwe"});
        new CreateAction().execute(input, tracker);
        assertThat(tracker.findAll()[0].getName(), is("qwe"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("asd");
        tracker.add(item);
        String id = tracker.findAll()[0].getId();
        String[] answers = {id};
        Input input = new StubInput(answers);
        new DeleteAction().execute(input, tracker);
        Item deletedItem = tracker.findById(id);
        Assert.assertNull(deletedItem);
    }

    @Test
    public void whenItemReplace() {
        Tracker tracker = new Tracker();
        Item item = new Item("qwe");
        tracker.add(item);
        String id = tracker.findAll()[0].getId();
        String[] answers = {id, "asd"};
        new ReplaceAction().execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(id);
        Assert.assertThat(replaced.getName(), Is.is("asd"));
    }

    @Test
    public void whenUserFindItemById() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("qwe");
        tracker.add(itemFirst);
        String id = tracker.findAll()[0].getId();
        String[] answers = {id};
        Input input = new StubInput(answers);
        new FindByIdAction().execute(input, tracker);
        Assert.assertThat(new String(out.toByteArray()),
                Is.is("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId() + "\r\n"));
        System.setOut(stdOut);
    }

    @Test
    public void whenUserFindItemByName() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("qwe");
        tracker.add(itemFirst);
        String name = tracker.findAll()[0].getName();
        String[] answers = {name};
        Input input = new StubInput(answers);
        new FindByNameAction().execute(input, tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId())
                .toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(expect));
        System.setOut(stdOut);
    }

    @Test
    public void whenUserFindTwoItemByName() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("qwe");
        Item itemSecond = new Item("qwe");
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        String name = tracker.findAll()[0].getName();
        String[] answers = {name};
        Input input = new StubInput(answers);
        new FindByNameAction().execute(input, tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId())
                .add("Имя заявки: " + itemSecond.getName() + "; ID заявки: " + itemSecond.getId())
                .toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(expect));
        System.setOut(stdOut);
    }

    @Test
    public void whenUserFindAllItemByName() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("qwe");
        Item itemSecond = new Item("asd");
        Item itemThird = new Item("zxc");
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        tracker.add(itemThird);
        String name = tracker.findAll()[0].getName();
        String[] answers = {name};
        Input input = new StubInput(answers);
        new FindAllAction().execute(input, tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId())
                .add("Имя заявки: " + itemSecond.getName() + "; ID заявки: " + itemSecond.getId())
                .add("Имя заявки: " + itemThird.getName() + "; ID заявки: " + itemThird.getId())
                .toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(expect));
        System.setOut(stdOut);
    }
}