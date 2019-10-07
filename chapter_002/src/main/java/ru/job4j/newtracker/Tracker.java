package ru.job4j.newtracker;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean isReplase = false;
        for (int i = 0; i != this.position; i++) {
            if (items[i].getId().equals(id)) {
                item.setId(items[i].getId());
                items[i] = item;
                isReplase = true;
                break;
            }
        }
        return isReplase;
    }

    public boolean delete(String id) {
        return false;
    }

    public Item[] findAll() {
        return this.items;
    }

    public Item[] findByName(String key) {
        return this.items;
    }

    public Item findById(String id) {
        return items[0];
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random(System.currentTimeMillis()).nextLong());
    }
}
