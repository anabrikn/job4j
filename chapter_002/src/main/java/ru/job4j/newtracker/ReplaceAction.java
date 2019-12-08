package ru.job4j.newtracker;

import java.util.function.Consumer;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("Введите ID заявки:");
        Item item = new Item(input.askStr("Введите имя заявки:"));
        if (tracker.replace(id, item)) {
            output.accept("Заявка отредактирована.");
        } else {
            output.accept("Заявка с указанным ID не найдена.");

        }
        return true;
    }
}
