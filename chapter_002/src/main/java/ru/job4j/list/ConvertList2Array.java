package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int[] elements: array) {
            for (int j = 0; j < cells; j++) {
                elements[j] = index < list.size() ? list.get(index) : 0;
                index++;
            }

        }
        return array;
    }
}