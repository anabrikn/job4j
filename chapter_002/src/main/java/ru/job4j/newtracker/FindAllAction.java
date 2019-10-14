package ru.job4j.newtracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item e: tracker.findAll()) {
            System.out.println(e.toString());
        }
        return true;
    }
}
