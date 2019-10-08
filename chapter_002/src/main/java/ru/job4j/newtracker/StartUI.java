package ru.job4j.newtracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                for (Item e: tracker.findAll()) {
                    System.out.println(e.toString());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Введите имя заявки:");
                Item item = new Item(scanner.nextLine());
                System.out.println("Введите ID заявки:");
                String id = scanner.nextLine();
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка отредактирована.");
                } else {
                    System.out.println("Заявка с указанным ID не найдена.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Введите id заявки, которую хотите удалить:");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("Заявка с указанным id была удалена.");
                } else {
                    System.out.println("Заявка с указанным id не найдена.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.println("Введите ID заявки, которую хотите найти:");
                String id = scanner.nextLine();

                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Заявка с указанным id не найдена.");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.println("Введите имя заявки:");
                String name = scanner.nextLine();

                Item[] foundItem = tracker.findByName(name);
                if (foundItem.length != 0) {
                    for (Item e: foundItem) {
                        System.out.println(e.toString());
                    }
                } else {
                    System.out.println("Заявок с таким именем нет в списке.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        // добавить остальные пункты меню.
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
