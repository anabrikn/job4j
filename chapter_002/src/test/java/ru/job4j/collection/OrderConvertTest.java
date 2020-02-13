package ru.job4j.collection;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = List.of(
                new Order("3sfe", "Dress"),
                new Order("3qwe", "Bring"),
                new Order("3sfe", "Go out"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Go out")));
    }
}
