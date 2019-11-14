package ru.job4j.newtracker;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.print("Пожалуйста, введите корректные данные" + System.lineSeparator());
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException moe) {
                System.out.print("Пожалуйста, введите ключ из меню" + System.lineSeparator());
            } catch (NumberFormatException nfe) {
                System.out.print("Пожалуйста, введите корректные данные" + System.lineSeparator());
            }
        } while (invalid);
        return value;
    }
}
