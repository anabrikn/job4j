package ru.job4j.array;

/**
 * @author anna brik
 * @version 1
 * @since 04.01.19
 */

public class MatrixCheck {
    /**
     * @param data двумерный массив булевых значений.
     * @return результат проверки, что все элементы по диагоналям равны true или false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i1 = data.length - 1, i2 = 0, j = data.length - 1; i1 > 0; i1--, i2++, j--) {
            if (data[i1][j] != data[i1 - 1][j - 1] || data[i2][j] != data[i2 + 1][j - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}