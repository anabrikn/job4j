package ru.job4j.bank.parts;

import java.util.Objects;

public class User implements Comparable {
    private String name;
    private String passport;

    public User(String passport) {
        this.name = "unknown";
        this.passport = passport;
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getPassport().equals(user.getPassport()) && getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassport());
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", passport=" + passport + '}';
    }

    @Override
    public int compareTo(Object o) {
        User anotherUser = (User) o;
        int result = this.name.compareTo(anotherUser.name);
        if (result != 0) {
            return result;
        }
        result = this.passport.compareTo(anotherUser.passport);
        if (result != 0) {
            return result;
        }
        return 0;
    }
}