package ru.job4j.newtracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}));
        input.askInt("Enter", 1);
        String expect = new StringJoiner(System.lineSeparator())
                .add("Пожалуйста, введите корректные данные\r\n")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
