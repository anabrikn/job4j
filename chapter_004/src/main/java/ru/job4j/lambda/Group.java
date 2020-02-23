package ru.job4j.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Group {
    /*
    Метод, который сгруппирует студентов по секциям.
    */
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(st -> st.getUnits().stream() // берем студента, берем у него список секций и вызываем стрим для этого списка
                        .map(gr -> new Holder(gr, st.getName()) // создаем объект Holder {секция (key), имя студента(value)} для каждого значения из списка секций
                        )
                )
                .collect(// сбор данных в карту - Map<String, Set<String>>
                        groupingBy(// метод groupingBy получает два аргумента - 1. ключ (ключи) по которому будет группироваться списки
                                                // 2. коллектор, который будет собирать значения с одинаковым ключом в один сет
                            Holder::getKey, // (поле key объекта Holder) ключ карты - String - название секции
                            Collector.of(// значение карты - Set<String> - список студентов посещающих эту секцию, чтобы собрать его создаем свой << нисходящий коллектор >> (который применяется к результатам первого коллектора - ???)
                                    HashSet::new, // создаем новый сет
                                    (set, el) -> set.add(el.value), // добавляем в сет поле value объекта Holder - ученика
                                    (left, right) -> { // ??? left - какой-то основной сет? right - сет с именем ученика из конкретного объекта Holder (set.add(el.value)) ?
                                        left.addAll(right); // в общий сет left сливается каждый сет с именем ученика, созданного из Holder-а с соответствующим ключом
                                        return left; // возвращается общий сет для конкретного ключа
                                    }
                            )  //toSet() - ?
                        )
                );
    }

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }
    }
}

/*
2.4. Изменение типа возвращаемого значения Map
Вторая перегрузка groupingBy требует дополнительного второго коллектора (нисходящего коллектора), который применяется к результатам первого коллектора.
Когда мы указываем только функцию классификации, а не нижестоящий коллектор, за кулисами используется коллектор toList () .
Давайте использовать toSet () сборщик в качестве нижестоящего сборщика и получить Set постов в блоге (вместо List ):
Map<BlogPostType, Set<BlogPost>> postsPerType = posts.stream()
  .collect(groupingBy(BlogPost::getType, toSet()));
 */