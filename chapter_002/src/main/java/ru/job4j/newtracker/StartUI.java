package ru.job4j.newtracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;

        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new item ====");
                String name = input.askStr("Enter name:");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                for (Item e: tracker.findAll()) {
                    System.out.println(e.toString());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                Item item = new Item(input.askStr("Введите имя заявки:"));
                String id = input.askStr("Введите ID заявки:");
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка отредактирована.");
                } else {
                    System.out.println("Заявка с указанным ID не найдена.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                String id = input.askStr("Введите id заявки, которую хотите удалить:");
                if (tracker.delete(id)) {
                    System.out.println("Заявка с указанным id была удалена.");
                } else {
                    System.out.println("Заявка с указанным id не найдена.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                String id = input.askStr("Введите ID заявки, которую хотите найти:");

                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Заявка с указанным id не найдена.");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                String name = input.askStr("Введите имя заявки:");

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
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
