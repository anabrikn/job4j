package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        return (HashSet<String>) list
                .stream()
                .map(Task::getNumber)
                .collect(Collectors.toSet());
    }
}

/*
[#212653]
 */