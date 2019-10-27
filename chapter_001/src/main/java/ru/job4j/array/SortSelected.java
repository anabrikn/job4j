package ru.job4j.array;

public class SortSelected {
    public static int[] sort(int[] data) {
        int min;
        int index;
        for (int i = 0; i < data.length; i++) {
            min = MinDiapason.findMin(data, i, data.length);
            index = FindLoop.indexOf(data, min, i, data.length);
            if (index != i) {
                data[index] = data[i];
                data[i] = min;
            }
        }
        return data;
    }
}
