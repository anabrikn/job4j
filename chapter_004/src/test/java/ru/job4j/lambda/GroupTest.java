package ru.job4j.lambda;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupTest {
    @Test
    public void whenSomeTouristsHaveSameAddresses() {
        Student student1 = new Student("Королев", Set.of("Дебаты", "Бег"));
        Student student2 = new Student("Самоваров", Set.of("Фехтование", "Программирование"));
        Student student3 = new Student("Астанина", Set.of("Футбол", "Бег", "Дебаты"));
        Student student4 = new Student("Галушко", Set.of("Дебаты", "Плавание"));
        Student student5 = new Student("Поляков", Set.of("Программирование", "Дебаты"));
        Student student6 = new Student("Шкипер", Set.of("Программирование", "Плавание", "Футбол"));
        Student student7 = new Student("Самоваров", Set.of("Плавание"));
        Student student8 = new Student("Архипова", Set.of("Программирование", "Бег"));
        Student student9 = new Student("Галушко", Set.of("Фехтование", "Футбол"));
        List<Student> students = Arrays.asList(
                student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9
        );
        Map<String, Set<String>> expected = Map.of(
                "Бег", Set.of("Королев", "Астанина", "Архипова"),
                "Дебаты", Set.of("Королев", "Астанина", "Галушко", "Поляков"),
                "Фехтование", Set.of("Самоваров", "Галушко"),
                "Программирование", Set.of("Самоваров", "Поляков", "Шкипер", "Архипова"),
                "Футбол", Set.of("Астанина", "Шкипер", "Галушко"),
                "Плавание", Set.of("Галушко", "Шкипер", "Самоваров")
                );
        Map<String, Set<String>> result = Group.sections(students);
        assertThat(result, is(expected));
    }
}
