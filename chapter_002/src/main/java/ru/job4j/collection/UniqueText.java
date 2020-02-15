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