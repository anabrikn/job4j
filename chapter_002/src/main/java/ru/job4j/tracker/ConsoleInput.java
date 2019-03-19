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
    public String ask(String question) {
        System.out.println(question);
        return scan.nextLine();
    }
}
