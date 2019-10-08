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
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                result = true;
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                position--;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] resultArr = new Item[position];
        for (int i = 0; i != this.position; i++) {
            resultArr[i] = this.items[i];
        }
        return resultArr;
    }

    public Item[] findByName(String key) {
        Item[] arr = new Item[position];
        int k = 0;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                arr[k] = this.items[i];
                k++;
            }
        }
        Item[] resultArray = new Item[k];
        System.arraycopy(arr, 0, resultArray, 0, resultArray.length);
        return resultArray;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random().nextLong());
    }
}
