package ru.job4j.newtracker;

import java.util.function.Consumer;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("Введите ID заявки, которую хотите найти:");

        Item item = tracker.findById(id);
        if (item != null) {
            output.accept(item.toString());
        } else {
            output.accept("Заявка с указанным id не найдена.");
        }
        return true;
    }
}
