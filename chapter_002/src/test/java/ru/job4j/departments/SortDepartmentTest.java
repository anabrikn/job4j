package ru.job4j.departments;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.ArrayList;

public class SortDepartmentTest {
    @Test
    public void whenJustSorting() {
        String[] arr = {"K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, arr);
        SortDepartment sd = new SortDepartment();
        TreeSet<String> tree = sd.abs(list);
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (String s: tree) {
            joiner.add(s);
        }
        String expect = new StringJoiner(System.lineSeparator())
                .add("K1")
                .add("K1/SK1")
                .add("K1/SK1/SSK1")
                .add("K1/SK1/SSK2")
                .add("K1/SK2")
                .add("K2")
                .add("K2/SK1")
                .add("K2/SK1/SSK1")
                .add("K2/SK1/SSK2")
                .toString();
        assertThat(joiner.toString(), is(expect));
    }

    @Test
    public void whenDescSorting() {
        String[] arr = {"K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, arr);
        SortDepartment sd = new SortDepartment();
        TreeSet<String> tree = sd.desc(list);
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (String s: tree) {
            joiner.add(s);
        }
        String expect = new StringJoiner(System.lineSeparator())
                .add("K2")
                .add("K2/SK1")
                .add("K2/SK1/SSK2")
                .add("K2/SK1/SSK1")
                .add("K1")
                .add("K1/SK2")
                .add("K1/SK1")
                .add("K1/SK1/SSK2")
                .add("K1/SK1/SSK1")
                .toString();
        assertThat(joiner.toString(), is(expect));
    }
}
