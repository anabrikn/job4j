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
        boolean result;
        boolean diagonal1 = true;
        boolean diagonal2 = true;

        for (int i = data.length - 1, j = data.length - 1; i > 0; i--, j--) {
            if (data[i][j] != data[i - 1][j - 1]) {
                diagonal1 = false;
                break;
            }
        }

        for (int i = 0, j = data[0].length - 1; j > 0; i++, j--) {
            if (data[i][j] != data[i + 1][j - 1]) {
                diagonal2 = false;
                break;
            }
        }

        result = diagonal1 && diagonal2;
        return result;
    }
}
