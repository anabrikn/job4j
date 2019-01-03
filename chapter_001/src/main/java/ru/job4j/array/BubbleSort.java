package ru.job4j.array;

/**
 * @author anna brik
 * @version 1
 * @since 03.01.19
 */

public class BubbleSort {
    /**
     * @param array массив чисел.
     * @return отсортированный массив чисел.
     */
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