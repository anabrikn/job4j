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
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "0"}));
        input.askInt("Enter", 1);
        String expect = new StringJoiner(System.lineSeparator())
                .add("Пожалуйста, введите корректные данные" + System.lineSeparator())
                .toString();
        assertThat(out.toString(), is(expect));
    }


    @Test
    public void whenInvalidRangeInput() {
        StubInput stubInput = new StubInput(new String[] {"10", "0"});
        ValidateInput input = new ValidateInput(stubInput);
        input.askInt("Enter", 1);
        String expect = new StringJoiner(System.lineSeparator())
                .add("Пожалуйста, введите ключ из меню" + System.lineSeparator())
                .toString();
        assertThat(out.toString(), is(expect));
    }
}
