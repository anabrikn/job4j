package ru.job4j.departments;

import java.util.Comparator;

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
