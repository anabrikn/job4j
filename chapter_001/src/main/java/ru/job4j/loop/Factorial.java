package ru.job4j.loop;
/**
 * @author anna brik
 * @version 1
 * @since 28.12.18
 */
public class Factorial {
    /**
     * @param n натуральное число.
     * @return факториал числа n.
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
