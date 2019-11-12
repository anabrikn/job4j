package ru.job4j.compare;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.*;

public class SortUserTest {
    @Test
    public void whenSortSomeUsersListByAge() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        User user1 = new User("Alla", 12);
        User user2 = new User("Ira", 22);
        User user3 = new User("Aleksei", 32);
        User user4 = new User("Andrew", 42);
        list.add(user2);
        list.add(user4);
        list.add(user1);
        list.add(user3);
        Set<User> result = sortUser.sort(list);
        assertThat(result.iterator().next(), is(user1));
    }
}
