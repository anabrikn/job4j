package ru.job4j.newtracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}