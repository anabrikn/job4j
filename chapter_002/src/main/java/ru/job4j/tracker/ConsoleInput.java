package ru.job4j.tracker;

import java.util.Scanner;
/**
 * @author anna brik
 * @version 1
 * @since 03.03.19
 */
public class ConsoleInput implements Input {
    private Scanner scan = new Scanner(System.in);

    /**
     * @param question сообщение для пользователя, какого типа информацию пользователь должен ввести.
     * @return строка, введенная пользователем.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scan.nextLine();
    }

    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Выход за пределы диапазона");

        }
        return key;
    }
}
