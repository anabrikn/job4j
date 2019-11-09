package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (!tasks.isEmpty()) {
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                if (task.getPriority() < t.getPriority()) { //tasks.get(i - 1).getPriority()
                    tasks.add(i, task);
                    break;
                }
            }
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}