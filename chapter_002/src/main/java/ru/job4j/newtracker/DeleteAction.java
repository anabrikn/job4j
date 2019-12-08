package ru.job4j.newtracker;

import java.util.function.Consumer;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("Введите id заявки, которую хотите удалить:");
        if (tracker.delete(id)) {
            output.accept("Заявка с указанным id была удалена.");
        } else {
            output.accept("Заявка с указанным id не найдена.");
        }
        return true;
    }
}
