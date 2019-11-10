package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    List<Integer> list = new ArrayList<>();
    public List<Integer> toList(int[][] array) {
        for (int[] element: array) {
            for (int e: element) {
                list.add(e);
            }
        }
        return list;
    }
}