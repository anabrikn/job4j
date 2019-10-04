package ru.job4j.profession;

public class Tooth {
    private int number;
    private boolean isIll = false;

    public Tooth(int number, boolean isIll) {
        this.number = number;
        this.isIll = isIll;
    }

    public boolean isIll() {
        return isIll;
    }

    public void setIll(boolean ill) {
        isIll = ill;
    }
}
