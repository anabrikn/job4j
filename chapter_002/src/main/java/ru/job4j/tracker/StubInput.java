package ru.job4j.tracker;
/**
 * @author anna brik
 * @version 1
 * @since 20.03.19
 */
public class StubInput implements Input {
    /**
     * массив строк для иммитации пользовательского ввода
     */
    private final String[] value;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * @param question сообщение для пользователя, какого типа информацию пользователь должен ввести.
     * @return строка-элемент массива с индексом position, из массива строк,
     * переданных в конструктор при создании объекта StubInput.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Выход за пределы диапазона");
        }
    }
}
