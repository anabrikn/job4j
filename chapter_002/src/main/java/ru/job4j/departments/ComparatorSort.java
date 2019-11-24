package ru.job4j.departments;

import java.util.Comparator;

// !!!дописать в основном классе метод для обрезания голов
// сначала сравниваем головы строк -
// если головы разные: сортировать в обратном порядке (голова больше - в конец, голова меньше в начало)
// если головы одинаковые - сравниваем дальше
// сравниваем длину строк
// если длина одинаковая - порядок сортировки обратный
// если длина разная - по возрастанию
//
public class ComparatorSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        int result;
        if (SortDepartment.getHeadCode(o1).equals(SortDepartment.getHeadCode(o2))) {
            if (o1.length() == o2.length()) {
                result = o1.compareTo(o2) * (-1);
            } else {
                result = o1.length() - o2.length();
            }
        } else {
            result = o1.compareTo(o2) * (-1);
        }

        return result;
    }
}
