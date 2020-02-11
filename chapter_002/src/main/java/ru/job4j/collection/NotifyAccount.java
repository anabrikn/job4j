package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        accounts.forEach(s -> rsl.add(s));
        return rsl;
    }
}