package ru.job4j.newtracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.hamcrest.core.Is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.function.Consumer;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
    private final PrintStream def = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void loadSys() {
        System.setOut(def);
    }

    @Test
    public void whenPrtMenu() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        ExitStubAction action = new ExitStubAction();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(action);
        new StartUI().init(input, new Tracker(), actions, output);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. === Exit Program ====")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        ExitStubAction action = new ExitStubAction();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(action);
        new StartUI().init(input, new Tracker(), actions, output);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"qwe"});
        new CreateAction().execute(input, tracker, output);
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
        new DeleteAction().execute(input, tracker, output);
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
        new ReplaceAction().execute(new StubInput(answers), tracker, output);
        Item replaced = tracker.findById(id);
        Assert.assertThat(replaced.getName(), Is.is("asd"));
    }

    @Test
    public void whenUserFindItemById() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("qwe");
        tracker.add(itemFirst);
        String id = tracker.findAll()[0].getId();
        String[] answers = {id};
        Input input = new StubInput(answers);
        new FindByIdAction().execute(input, tracker, output);
        Assert.assertThat(new String(out.toByteArray()),
                Is.is("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId() + System.lineSeparator()));
    }

    @Test
    public void whenUserFindItemByName() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("qwe");
        tracker.add(itemFirst);
        String name = tracker.findAll()[0].getName();
        String[] answers = {name};
        Input input = new StubInput(answers);
        new FindByNameAction().execute(input, tracker, output);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId())
                .toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(expect));
    }

    @Test
    public void whenUserFindTwoItemByName() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("qwe");
        Item itemSecond = new Item("qwe");
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        String name = tracker.findAll()[0].getName();
        String[] answers = {name};
        Input input = new StubInput(answers);
        new FindByNameAction().execute(input, tracker, output);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId())
                .add("Имя заявки: " + itemSecond.getName() + "; ID заявки: " + itemSecond.getId())
                .toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(expect));
    }

    @Test
    public void whenUserFindAllItemByName() {
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
        new FindAllAction().execute(input, tracker, output);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Имя заявки: " + itemFirst.getName() + "; ID заявки: " + itemFirst.getId())
                .add("Имя заявки: " + itemSecond.getName() + "; ID заявки: " + itemSecond.getId())
                .add("Имя заявки: " + itemThird.getName() + "; ID заявки: " + itemThird.getId())
                .toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(expect));
    }
}