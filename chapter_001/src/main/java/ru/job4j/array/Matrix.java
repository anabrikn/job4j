package ru.job4j.array;

/**
 * @author anna brik
 * @version 1
 * @since 03.01.19
 */
public class Matrix {
    /**
     * @param size размер матрицы.
     * @return двумерный массив размера size * size заполненный значениями таблицы умножения до size.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int indexI = 0; indexI < size; indexI++) {
            for (int indexJ = 0; indexJ < size; indexJ++) {
                table[indexI][indexJ] = (indexI + 1) * (indexJ + 1);
            }
        }
        return table;
    }
}
