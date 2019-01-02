package ru.job4j.array;

/**
 * @author anna brik
 * @version 1
 * @since 02.01.19
 */
public class Square {
    /**
     * @param bound длина массива, число, до которого производить возведение в степень.
     * @return массив чисел-результатов возведения в степень.
     */

    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0, i = 1; index < rst.length; index++, i++) {
            rst[index] = (int) Math.pow(i, 2);
        }
        return rst;
    }
}
