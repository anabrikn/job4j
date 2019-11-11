package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenConvertedThenMapSizeIs() {
        UserConvert converter = new UserConvert();
        List<User> convertList = new ArrayList<>();
        convertList.add(new User(111, "Alla", "Bobruisk"));
        convertList.add(new User(222, "Bella", "Mukhovsk"));
        convertList.add(new User(333, "Cillia", "Uryupinsk"));
        HashMap<Integer, User> resultList = converter.process(convertList);
        assertThat(resultList.size(), is(3));
    }

    @Test
    public void whenFindUserByKey() {
        UserConvert converter = new UserConvert();
        List<User> convertList = new ArrayList<>();
        User alla = new User(111, "Alla", "Bobruisk");
        User bella = new User(222, "Bella", "Mukhovsk");
        User cillia = new User(333, "Cillia", "Uryupinsk");
        convertList.add(alla);
        convertList.add(bella);
        convertList.add(cillia);
        HashMap<Integer, User> resultList = converter.process(convertList);
        assertThat(resultList.get(222), is(bella));
    }

    @Test
    public void whenFindByKeyIs() {
        UserConvert converter = new UserConvert();
        List<User> convertList = new ArrayList<>();
        convertList.add(new User(111, "Alla", "Bobruisk"));
        convertList.add(new User(222, "Bella", "Mukhovsk"));
        convertList.add(new User(333, "Cillia", "Uryupinsk"));
        HashMap<Integer, User> resultList = converter.process(convertList);
        assertThat(resultList.containsKey(333), is(true));
    }

    @Test
    public void whenEmpty() {
        UserConvert converter = new UserConvert();
        List<User> convertList = new ArrayList<>();
        HashMap<Integer, User> resultList = converter.process(convertList);
        assertThat(resultList.containsKey(333), is(false));
    }

    @Test
    public void whenEmptyThenSize() {
        UserConvert converter = new UserConvert();
        List<User> convertList = new ArrayList<>();
        HashMap<Integer, User> resultList = converter.process(convertList);
        assertThat(resultList.size(), is(0));
    }
}
