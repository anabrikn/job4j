package ru.job4j.array;

/**
 * @author anna brik
 * @version 1
 * @since 02.01.19
 */
public class FindLoop {
    /**
     * @param data массив чисел.
     * @param el значение, которое необходимо найти в массиве.
     * @return результат поиска.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
