package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедщих пользователей.
     */
    public List<Person> find(String key) {
        return persons.stream()
                .flatMap(Stream::ofNullable)
                .filter(person -> person.getName().contains(key)
                        || person.getSurname().contains(key)
                        || person.getAddress().contains(key)
                        || person.getPhone().contains(key))
                .collect(Collectors.toList());
    }
}
/*
List<Person> result = new ArrayList<>();
        for (var i = 0; i < persons.size(); i++) {
            var person = persons.get(i);
            String[] data = {person.getName(), person.getSurname(), person.getPhone(), person.getAddress()};
            for (var j = 0; j < data.length; j++) {
                if (data[i].contains(key)) {
                    result.add(person);
                    break;
                }
            }
        }
        return result;
*/