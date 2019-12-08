package ru.job4j.newtracker;

import java.util.ArrayList;
import java.util.function.Consumer;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String name = input.askStr("Введите имя заявки:");

        ArrayList<Item> foundItem = tracker.findByName(name);
        if (foundItem.size() != 0) {
            for (Item e: foundItem) {
                output.accept(e.toString());
            }
        } else {
            output.accept("Заявок с таким именем нет в списке.");
        }
        return true;
    }
}
