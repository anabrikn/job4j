package ru.job4j.newtracker;

import java.util.function.Consumer;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        for (Item e: tracker.findAll()) {
            output.accept(e.toString());
        }
        return true;
    }
}
