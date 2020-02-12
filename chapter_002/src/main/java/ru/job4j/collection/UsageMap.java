package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(Map.of(
                "yammy@yandex.ru", "Amy Moon",
                "wow@wip.ru", "Karry Soup",
                "chimy@yandex.ru", "Chimy Ghong")
        );
        map.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
/*
for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
 */