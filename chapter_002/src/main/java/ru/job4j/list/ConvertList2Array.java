package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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

    public List<Integer> convert(List<int[]> list) {
        List<Integer> resultList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (ListIterator<int[]> iterator = list.listIterator(); iterator.hasNext();) {
                int[] arr = iterator.next();
                for (int element : arr) {
                    resultList.add(element);
                }
            }
        }
        return resultList;
    }
}