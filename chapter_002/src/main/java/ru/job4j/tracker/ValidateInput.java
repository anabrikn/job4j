package ru.job4j.tracker;
/**
 * @author anna brik
 * @version 1
 * @since 31.07.19
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.print("Введите ключ из диапазона" + System.lineSeparator());
            } catch (NumberFormatException nfe) {
                System.out.print("Введите корректные данные" + System.lineSeparator());
            }
        } while (invalid);
        return value;
    }
}
