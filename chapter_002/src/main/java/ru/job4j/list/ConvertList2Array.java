package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer elements: list) {
            array[j][i] = elements;
            i++;
            if (i % cells == 0) {
                i = 0;
                j++;
            }
        }
        return array;
    }
}