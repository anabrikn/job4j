package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];

        int[] leftArray = left.length > right.length ? left : right;
        int[] rightArray = left.length > right.length ? right : left;
        int indexL = 0;
        int indexR = 0;
        int index = 0;

        while (index < rsl.length) {
            if (indexR < rightArray.length && indexL < leftArray.length) {
                if (leftArray[indexL] <= rightArray[indexR]) {
                    rsl[index] = leftArray[indexL];
                    indexL++;
                    index++;
                } else {
                    rsl[index] = rightArray[indexR];
                    indexR++;
                    index++;
                }
            } else if (indexL < leftArray.length) {
                rsl[index] = leftArray[indexL];
                indexL++;
                index++;
            } else if (indexR < rightArray.length) {
                rsl[index] = rightArray[indexR];
                indexR++;
                index++;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 2, 3},
                new int[] {1, 1, 3, 3, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}

/*
// сделать проверку, одинаковой ли длины массивы
            // или
            // проверка, что индекс можно инкрементировать (есть следующий элемент в массиве)
 */