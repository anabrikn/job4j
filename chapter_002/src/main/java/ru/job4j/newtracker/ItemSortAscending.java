package ru.job4j.newtracker;

import java.util.Comparator;

public class ItemSortAscending implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getId().compareTo(second.getId());
    }
}
