package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when67RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(67);
        assertThat(result, is(1));
    }

    @Test
    public void when76RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(76);
        assertThat(result, is(1));
    }

    @Test
    public void when1DollarToRubleThen67() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(67));
    }

    @Test
    public void when1EeuroToRubleThen76() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(76));
    }
}