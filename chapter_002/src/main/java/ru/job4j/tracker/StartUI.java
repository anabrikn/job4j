package ru.job4j.tracker;
/**
 * @author anna brik
 * @version 1
 * @since 03.03.19
 */
public class StartUI {
    /**
     * Константы для пользовательского ввода.
     */
    private static final String ADD = "0";
    private static final String FINDALL = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBUNAME = "5";
    private static final String EXIT = "6";

    /**
     * Поля класса для инициализации.
     */
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (FINDALL.equals(answer)) {
                this.findAll();
            } else if (REPLACE.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            }  else if (FINDBUNAME.equals(answer)) {
                this.findBuName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод выводит все заявки не экран.
     */
    private void findAll() {
        System.out.println("Вывод всех заявок.");
        Item[] allItems = tracker.findAll();
        if (allItems.length != 0) {
            for (Item item: allItems) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Заявок в трекере нет.");
        }
    }

    /**
     * Метод реализует редактирование уже имеющейся заявки.
     */
    private void edit() {
        System.out.println("Редактирование заявки.");
        if (this.tracker.replace(this.input.ask("Введите id заявки, которую хотите заменить:"),
                                 new Item(this.input.ask("Введите имя заявки:"),
                                          this.input.ask("Введите описание заявки:"),
                                          System.currentTimeMillis()))) {
            System.out.println("Заявка отредактирована");
        } else {
            System.out.println("Заявка с введенным id не найдена.");
        }
    }

    /**
     * Метод удаляет заявки из хранилища.
     */
    private void delete() {
        System.out.println("Удаление заявки.");
        if (this.tracker.delete(this.input.ask("Введите id заявки, которую хотите удалить:"))) {
            System.out.println("Заявка с указанным id была удалена.");
        } else {
            System.out.println("Заявка с указанным id не найдена.");
        }
    }

    /**
     * Метод реализует поиск заявки по id.
     */
    private void findById() {
        System.out.println("Поиск заявки по id.");
        Item foundItem = this.tracker.findById(this.input.ask("Введите id заявки, которую желаете найти:"));
        if (foundItem != null) {
            System.out.println(foundItem.toString());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findBuName() {
        System.out.println("Поиск заявки по имени.");
        Item[] foundItems = this.tracker.findByName(this.input.ask("Введите имя заявки:"));
        if (foundItems.length > 0) {
            for (Item item : foundItems) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Заявок с таким именем не найдено.");
        }
    }

    /**
     * Метод выводит меню в консоль.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item\n"
                            + "1. Show all items\n"
                            + "2. Edit item\n"
                            + "3. Delete item\n"
                            + "4. Find item by Id\n"
                            + "5. Find items by name\n"
                            + "6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
