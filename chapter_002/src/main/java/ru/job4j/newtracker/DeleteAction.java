package ru.job4j.newtracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки, которую хотите удалить:");
        if (tracker.delete(id)) {
            System.out.println("Заявка с указанным id была удалена.");
        } else {
            System.out.println("Заявка с указанным id не найдена.");
        }
        return true;
    }
}
