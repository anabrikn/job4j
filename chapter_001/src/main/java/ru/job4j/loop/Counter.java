package ru.job4j.loop;

/**
 * @author anna brik
 * @version 1
 * @since 28.12.18
 */
public class Counter {
    /**
     * @param start число начало диапазона.
     * @param finish число конец диапазона.
     * @return сумма всех четных чисел диапазона.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int index = start; index <= finish; index++) {
            if(index%2 == 0) {
                result += index;
            }
        }
        return result;
    }
}
