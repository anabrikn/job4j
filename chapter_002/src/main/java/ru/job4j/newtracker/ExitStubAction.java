package ru.job4j.newtracker;

public class ExitStubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "=== Exit Program ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
