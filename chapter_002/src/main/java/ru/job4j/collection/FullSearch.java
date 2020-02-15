package ru.job4j.collection;

import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

public class FullSearch {
    public static Set<String> extractNumber(List<Task> list) {
        return list
                .stream()
                .map(Task::getNumber)
                .collect(Collectors.toSet());
    }
}