package ru.job4j.newtracker;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.Consumer;

public class StartUI {
    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions, Consumer<String> output) {
        boolean run = true;
        while (run) {
            this.showMenu(actions, output);
            int select = input.askInt("Select: ", actions.size());
            run = actions.get(select).execute(input, tracker, output);
        }
    }

    private void showMenu(ArrayList<UserAction> actions, Consumer<String> output) {
        output.accept("Menu.");
        int index = 0;
        for (ListIterator<UserAction> iterator = actions.listIterator(); iterator.hasNext(); index++) {
            output.accept(index + ". " + iterator.next().name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        Consumer<String> output = System.out::println;

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new FindAllAction());
        actions.add(new ReplaceAction());
        actions.add(new DeleteAction());
        actions.add(new FindByIdAction());
        actions.add(new FindByNameAction());
        actions.add(new ExitStubAction());
        new StartUI().init(validate, tracker, actions, output);
    }
}
