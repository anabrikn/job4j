package ru.job4j.array;

public class ArrayChar {
    private char[] data;

    /**
     * @param line строка - слово для проверки .
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return true, если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index < value.length; index++) {
            if (value[index] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
