package ru.job4j.convert;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> resultList = new HashMap<>();

        for (ListIterator<User> iterator = list.listIterator(); iterator.hasNext();) {
            User value = iterator.next();
            resultList.put(value.getId(), value);
        }

        return resultList;
    }
}