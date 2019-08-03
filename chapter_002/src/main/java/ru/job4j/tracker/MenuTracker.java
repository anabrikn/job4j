package ru.job4j.tracker;

/**
 * @author anna brik
 * @version 1
 * @since 30.06.19
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
    }

    public int getActionsLength() {
        return actions.length;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            long time = System.currentTimeMillis();
            tracker.add(new Item(name, desc, time));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item.");
        }
    }

    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Вывод всех заявок.");
            Item[] allItems = tracker.findAll();
            if (allItems.length != 0) {
                for (Item item: allItems) {
                    System.out.print(String.format("%s%s", item.toString(), System.lineSeparator()));
                }
            } else {
                System.out.print("Заявок в трекере нет.\n");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    private class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Редактирование заявки.");
            if (tracker.replace(input.ask("Введите id заявки, которую хотите заменить:"),
                    new Item(input.ask("Введите имя заявки:"),
                            input.ask("Введите описание заявки:"),
                            System.currentTimeMillis()))) {
                System.out.println("Заявка отредактирована");
            } else {
                System.out.println("Заявка с введенным id не найдена.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Удаление заявки.");
            if (tracker.delete(input.ask("Введите id заявки, которую хотите удалить:"))) {
                System.out.println("Заявка с указанным id была удалена.");
            } else {
                System.out.println("Заявка с указанным id не найдена.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Поиск заявки по id.");
            Item foundItem = tracker.findById(input.ask("Введите id заявки, которую желаете найти:"));
            if (foundItem != null) {
                System.out.println(foundItem.toString());
            } else {
                System.out.println("Заявка с таким id не найдена");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }

    private class FindItemByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Поиск заявки по имени.");
            Item[] foundItems = tracker.findByName(input.ask("Введите имя заявки:"));
            if (foundItems.length > 0) {
                for (Item item : foundItems) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("Заявок с таким именем не найдено.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name.");
        }
    }
}