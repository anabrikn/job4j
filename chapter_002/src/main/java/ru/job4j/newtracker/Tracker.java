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
        /*
        boolean isReplace = false;
        for (int i = 0; i != this.position; i++) {
            if (items[i].getId().equals(id)) {
                item.setId(items[i].getId());
                items[i] = item;
                isReplace = true;
                break;
            }
        }
         */
    }

    public boolean delete(String id) {
        boolean result = false;
        for (ListIterator<Item> iterator = items.listIterator(); iterator.hasNext();) {
            Item itemForDelete = iterator.next();
            if (itemForDelete.getId().equals(id)) {
                result = true;
                items.remove(itemForDelete);
                break;
            }
        }
        return result;
        /*
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
         */
    }

    public Item[] findAll() {
        return items.toArray(new Item[items.size()]);
        /*
        Item[] resultArr = new Item[position];
        for (int i = 0; i != this.position; i++) {
            if (this.items[i] != null) {
                resultArr[i] = this.items[i];
            }
        }
        return resultArr;
         */
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
        /*
        public Item[] findByName(String key)
        return arrayList.toArray(new Item[arrayList.size()])

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
         */
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
