package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(List.of(origin));
        boolean rsl = List.of(text).stream().allMatch(check::contains);
        return rsl;
    }
}
/*
        allMatch(Predicate predicate) — возвращает true, если все элементы стрима удовлетворяют условию.
        Если встречается какой-либо элемент, для которого результат вызова функции-предиката будет false,
        то оператор перестаёт просматривать элементы и возвращает false
        for (String e : text) {
            if (!check.contains(e)) {
                rsl = false;
                break;
            }
        }
        // for-each origin -> new HashSet.
        // for-each text -> hashSet.contains
        */