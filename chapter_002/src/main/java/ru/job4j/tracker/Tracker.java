package ru.job4j.tracker;
import java.util.Random;

/**
 * @author anna brik
 * @version 1
 * @since 02.02.19
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;

    private static final Random RN = new Random(System.currentTimeMillis());
    /**
     * @param item объект, который нужно добавить в первую же свободную ячейку.
     * @return item, который добавили в массив items объекта tracker.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * @param id объекта, который нужно заменить.
     * @param item объект, который должен занять место удаленного.
     * @return boolean результат - удалось ли провести операцию.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i != this.position; i++) {
            if (items[i].getId().equals(id)) {
                item.setId(items[i].getId());
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @param id объекта, который нужно удалить из массива this.items, со смещением всех последующих объектов влево.
     * @return boolean результат - удалось ли провести операцию.
     */
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

    /**
     * @return копия массива this.items без null элементов.
     */
    public Item[] findAll() {
        Item[] resultArr = new Item[position];
        for (int i = 0; i != this.position; i++) {
            resultArr[i] = this.items[i];
        }
        return resultArr;
    }

    /**
     * @param key имя, по которому ищутся все совпадения в поле name, объектов массива items.
     * @return массив, включающий в себя все объекти с именем key.
     */
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

    /**
     * @param id объекта, который нужно найти.
     * @return item объект, который необходимо было найти или null, если найти его не удалось.
     */
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

    /**
     * @return id генерирующийся на основании времени и произвольного числа.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}