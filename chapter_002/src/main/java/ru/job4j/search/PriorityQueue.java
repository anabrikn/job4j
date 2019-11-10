package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int i = 0;
        boolean isAdd = false;
        if (!tasks.isEmpty()) {
            for (ListIterator<Task> iterator = tasks.listIterator(); iterator.hasNext(); i++) {
                Task t = iterator.next();
                if (task.getPriority() < t.getPriority()) {
                    tasks.add(i, task);
                    isAdd = true;
                    break;
                }
            }
            if (!isAdd) {
                tasks.add(task);
            }
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public Task takeLast() {
        return this.tasks.pollLast();
    }
}