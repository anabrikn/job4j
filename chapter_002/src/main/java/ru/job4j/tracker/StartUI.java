package ru.job4j.tracker;
/**
 * @author anna brik
 * @version 1
 * @since 03.03.19
 */
public class StartUI {
    /**
     * Поля класса для инициализации.
     */
    private final Input input;
    private final Tracker tracker;
    // массив значений нужно брать из меню трэкера, это ключи!!!!

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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int[] ranges = new int[menu.getActionsLength()]; //
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }
        menu.fillActions();
        do {
            System.out.println("Меню.");
            menu.show();
            menu.select(input.ask("select:", ranges)); //
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
