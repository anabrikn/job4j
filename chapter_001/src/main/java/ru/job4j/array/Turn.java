package ru.job4j.array;

/**
 * @author anna brik
 * @version 1
 * @since 02.01.19
 */
public class Turn {
    /**
     * @param array массив чисел.
     * @return тот же массив в развернутом виде.
     */
    public int[] back(int[] array) {
        int temp;
        for (int index = 0, i = array.length - 1; index < array.length / 2; index++, i--) {
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
