package ru.job4j.compare;

import java.util.*;
import java.util.Comparator;

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        Comparator<User> comparator = Comparator.comparing(obj -> obj.getName().length());
        Collections.sort(list, comparator);
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        });
        return list;
    }
}
