package ru.job4j.array;

public class BubbleSort {
    int[] sort(int[] array) {
        int temp;
        for (int j = array.length - 1; j != 0; j--) {
            for (int index = 0; index < j; index++) {
                if (array[index] > array[index + 1]) {
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }
}