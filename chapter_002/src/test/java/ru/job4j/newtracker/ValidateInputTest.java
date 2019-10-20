package ru.job4j.newtracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
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
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}));
        input.askInt("Enter", 1);
        String expect = new StringJoiner(System.lineSeparator())
                .add("Пожалуйста, введите корректные данные\r\n")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenInvalidRangeInput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput stubInput = new StubInput(new String[] {"10", "1"});
        ValidateInput input = new ValidateInput(stubInput);
        input.askInt("Enter", 1);
        String expect = new StringJoiner(System.lineSeparator())
                .add("Пожалуйста, введите ключ из меню\r\n")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
