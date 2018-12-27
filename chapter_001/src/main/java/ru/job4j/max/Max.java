package ru.job4j.max;

/**
 * @author anna brik
 * @version 1
 * @since 25.12.18
 */
public class Max {
    /**
     * @param first первое число.
     * @param second первое число.
     * @return максимальное из двух переданных чисел.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * @param first первое число.
     * @param second первое число.
     * @param third третье число.
     * @return максимальное из трех переданных чисел.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
