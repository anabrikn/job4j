package ru.job4j.newtracker;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки:");

        ArrayList<Item> foundItem = tracker.findByName(name);
        if (foundItem.size() != 0) {
            for (Item e: foundItem) {
                System.out.println(e.toString());
            }
        } else {
            System.out.println("Заявок с таким именем нет в списке.");
        }
        return true;
    }
    /*
    String name = input.askStr("Введите имя заявки:");

        Item[] foundItem = tracker.findByName(name);
        if (foundItem.length != 0) {
            for (Item e: foundItem) {
                System.out.println(e.toString());
            }
        } else {
            System.out.println("Заявок с таким именем нет в списке.");
        }
        return true;
     */
}
