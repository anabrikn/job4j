package ru.job4j.newtracker;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>(100);

    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean isReplace = false;
        int i = 0;
        for (ListIterator<Item> iterator = items.listIterator(); iterator.hasNext(); i++) {
            Item itemForReplace = iterator.next();
            if (itemForReplace.getId().equals(id)) {
                item.setId(itemForReplace.getId());
                items.add(i, item);
                isReplace = true;
                break;
            }
        }
        return isReplace;
    }

    public boolean delete(String id) {
        boolean result = false;
        int i = 0;
        for (ListIterator<Item> iterator = items.listIterator(); iterator.hasNext(); i++) {
            Item itemForDelete = iterator.next();
            if (itemForDelete.getId().equals(id)) {
                result = true;
                items.remove(i);
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return items.toArray(new Item[items.size()]);
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> arrayList = new ArrayList<>();
        for (ListIterator<Item> iterator = items.listIterator(); iterator.hasNext();) {
            Item itemForFind = iterator.next();
            if (itemForFind.getName().equals(key)) {
                arrayList.add(itemForFind);
            }
        }
        return arrayList;
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
