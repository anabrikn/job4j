package ru.job4j.array;

/**
 * @author anna brik
 * @version 1
 * @since 03.01.19
 */
public class Check {
    /**
     * @param data массив булевых значений.
     * @return результат проверки.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean temp = data[0];
        for (boolean datum : data) {
            if (temp == datum) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
