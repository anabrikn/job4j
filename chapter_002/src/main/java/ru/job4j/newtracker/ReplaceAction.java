package ru.job4j.newtracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите ID заявки:");
        Item item = new Item(input.askStr("Введите имя заявки:"));
        if (tracker.replace(id, item)) {
            System.out.println("Заявка отредактирована.");
        } else {
            System.out.println("Заявка с указанным ID не найдена.");
        }
        return true;
    }
}
