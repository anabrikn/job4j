package ru.job4j.newtracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new item ====");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAll(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        for (Item e: tracker.findAll()) {
            System.out.println(e.toString());
        }
    }

    public static void replace(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Введите ID заявки:");
        Item item = new Item(input.askStr("Введите имя заявки:"));
        if (tracker.replace(id, item)) {
            System.out.println("Заявка отредактирована.");
        } else {
            System.out.println("Заявка с указанным ID не найдена.");
        }
    }

    public static void delete(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Введите id заявки, которую хотите удалить:");
        if (tracker.delete(id)) {
            System.out.println("Заявка с указанным id была удалена.");
        } else {
            System.out.println("Заявка с указанным id не найдена.");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String id = input.askStr("Введите ID заявки, которую хотите найти:");

        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Заявка с указанным id не найдена.");
        }
    }

    public static void findBuName(Input input, Tracker tracker) {
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
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;

        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);

            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAll(input, tracker);
            } else if (select == 2) {
                StartUI.replace(input, tracker);
            } else if (select == 3) {
                StartUI.delete(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findBuName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
        /*
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");0
         */
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction()};
        new StartUI().init(input, tracker, actions);
    }
}
