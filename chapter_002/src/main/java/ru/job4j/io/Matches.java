package ru.job4j.io;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int match = 11;
        int count = 3;
        String player1 = "Игрок №1";
        String player2 = "Игрок №2";

        while (run) {
            if (count % 2 != 0) {
                System.out.println(player1);
            } else {
                System.out.println(player2);
            }

            System.out.println("На столе лежит " + match + " спичек.");
            System.out.println("Сколько спичек вы возьмете?");

            boolean runSelect = true;
            int select;

            do {
                try {
                    if (match > 2) {
                        System.out.println("Введите число от 1 до 3");
                    } else {
                        System.out.println("Введите число спичек не более " + match);
                    }

                    select = Integer.valueOf(sc.nextLine());
                    if (select <= match) {
                        if (select > 0 && select < 4) {
                            match = match - select;
                            runSelect = false;
                        }
                    } else {
                        System.out.println("На столе меньше спичек, чем вы хотите взять...");
                    }

                } catch (NumberFormatException ne) {
                    System.out.println("Нужно вводить число!");
                }
            } while (runSelect);

            System.out.println("На столе осталось " + match + " спичек.");
            if (match == 0) {
                run = false;
            }

            count++;
        }
    }
}
