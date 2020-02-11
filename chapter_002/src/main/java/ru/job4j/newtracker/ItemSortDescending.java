package ru.job4j.newtracker;

import java.util.Comparator;

public class ItemSortDescending implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.getId().compareTo(first.getId());
    }
}
