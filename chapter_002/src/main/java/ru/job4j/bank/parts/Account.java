package ru.job4j.bank.parts;

import java.util.Objects;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public boolean transferTo(Account destAcc, double amount) {
        boolean result = false;
        if (this.getValue() >= amount) {
            this.setValue(this.getValue() - amount);
            destAcc.setValue(destAcc.getValue() + amount);
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.getValue(), getValue()) == 0 && getRequisites().equals(account.getRequisites());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getRequisites());
    }

    @Override
    public String toString() {
        return "Account{" + "value=" + value + ", requisites=" + requisites + '}';
    }
}
