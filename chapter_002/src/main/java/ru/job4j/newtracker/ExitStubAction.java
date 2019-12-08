package ru.job4j.newtracker;

import java.util.function.Consumer;

public class ExitStubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "=== Exit Program ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
