package ru.job4j.newtracker;
import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        return false;
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

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random(System.currentTimeMillis()).nextLong());
    }
}
