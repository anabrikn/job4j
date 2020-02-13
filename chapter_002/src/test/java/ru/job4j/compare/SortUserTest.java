package ru.job4j.compare;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;

public class SortUserTest {
    @Test
    public void whenSortSomeUsersListByAge() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Alla", 12);
        User user2 = new User("Ira", 22);
        User user3 = new User("Aleksei", 32);
        User user4 = new User("Andrew", 42);
        List<User> list = List.of(user2, user4, user1, user3);
        Iterator<User> iterator = sortUser.sort(list).iterator();
        assertThat(iterator.next(), is(user1));
        assertThat(iterator.next(), is(user2));
        assertThat(iterator.next(), is(user3));
        assertThat(iterator.next(), is(user4));

    }

    @Test
    public void whenSortSomeUsersListByNamesLength() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Alla", 12);
        User user2 = new User("Ira", 22);
        User user3 = new User("Aleksei", 32);
        User user4 = new User("Andrew", 42);
        List<User> list = List.of(user1, user2, user3, user4).stream().sorted().collect(Collectors.toList());
        Iterator<User> iterator = sortUser.sortNameLength(list).iterator();
        assertThat(iterator.next(), is(user2));
        assertThat(iterator.next(), is(user1));
        assertThat(iterator.next(), is(user4));
        assertThat(iterator.next(), is(user3));
    }

    @Test
    public void whenSortSomeUsersListByNamesAndAge() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Alla", 12);
        User user2 = new User("Alla", 22);
        User user3 = new User("Aleksei", 32);
        User user4 = new User("Andrew", 42);
        List<User> list = List.of(user2, user3, user1, user4).stream().sorted().collect(Collectors.toList());
        Iterator<User> iterator = sortUser.sortByAllFields(list).iterator();
        assertThat(iterator.next(), is(user3));
        assertThat(iterator.next(), is(user1));
        assertThat(iterator.next(), is(user2));
        assertThat(iterator.next(), is(user4));
    }

}
